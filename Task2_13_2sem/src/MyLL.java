public class MyLL {
    private static class Node{
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) {
            this(value,null);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    private Node head;
    private Node tail;

    private int size;

    public MyLL(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(int val){
        Node n = new Node(val,head);
        if (isEmpty()){
            tail = n;
        }
        head = n;
        size++;
    }

    public void addLast(int val){
        if (isEmpty()){
            addFirst(val);
            return;
        }
        Node n = new Node(val);
        tail.next = n;
        tail = n;
        size++;
    }

    public String asString(){
        Node current = head.getNext();
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(head.getValue());
        for (int i = 1; i<size;i++){
            sb.append(", ").append(current.getValue());
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public int solve(){
        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }
        Node current = head;
        Node currPositive = null;
        Node ans = head;
        int counter = 1;
        int ncounter = 0;
        while(current!=null){
            if (current.getValue()>=0){
                currPositive = current;
                counter = 1;
            } else if(currPositive != null) {
                counter++;
            }
            if (counter>=ncounter){
                ncounter = counter;
                ans = currPositive;
            }
            current = current.getNext();
        }
        assert ans != null; /**!!!*/
        return ans.getValue();
    }
}
