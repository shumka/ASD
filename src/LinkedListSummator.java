public class LinkedListSummator {

    private Node a1 = new Node(11);
    private Node a2 = new Node(22);
    private Node a3 = new Node(11);
    private Node a4 = new Node(22);
    public void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.addInTail(a1);
        list.addInTail(a2);
        list2.addInTail(a1);
        list2.addInTail(a2);


    }

    public LinkedList addLists(LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            int sum = current1.value + current2.value;
            Node z = new Node(sum);
            result.addInTail(z);
            current1 = current1.next;
            current2 = current2.next;
        }

        return result;
    }

}
