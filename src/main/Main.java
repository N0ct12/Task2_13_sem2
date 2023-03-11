package main;

import java.text.ParseException;
import java.util.Locale;
import utils.*;

public class Main {
    public static void main(String[] args) throws Exception {
        MyLL list = new MyLL();
        list.addLast(-1);
        list.addLast(2);
        list.addLast(-3);
        list.addLast(-4);
        list.addLast(3);
        list.addLast(-5);
        list.addLast(-6);
//        list.addLast(-7);
        System.out.println(list.asString() + "\n" + list.size());
        System.out.println(list.solve());
        winMain();
    }
    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Table().setVisible(true);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}