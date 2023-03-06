public class Main {
    public static void main(String[] args) {
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
    }
}