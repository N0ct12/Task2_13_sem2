package main;

import utils.*;


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;



public class Table extends JFrame {
    private JPanel panel1;
    private JButton randomButton;
    private JButton importButton;

    private JTable mainTable;
    private JTextField answerField;
    private JButton solutionButton;
    private JFileChooser fileChooserOpen;

    private JMenuBar menuBarMain;

    private JMenu menuLookAndFeel;

    ArrayList<Integer> list;
    public Table() throws ParseException {
        this.setTitle("FrameMain");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        JTableUtils.initJTableForArray(mainTable, 40, false, true, false, true);
        //tableOutput.setEnabled(false);
        mainTable.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);


        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        JTableUtils.writeArrayToJTable(mainTable, new int[]{
                0, 1, 2, 3, 4
        });
        this.pack();


        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panel1) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(mainTable, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = ArrayUtils.createRandomIntArray(mainTable.getColumnCount(),-100,100);
                    JTableUtils.writeArrayToJTable(mainTable, arr);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        solutionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(mainTable);
                    MyLL list = ListUtils.convertArrayToLL(arr);
                    answerField.setText(String.valueOf(list.solve()));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
