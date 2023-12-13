//public class LinkedListSummator {
//
//    public LinkedList addLists(LinkedList l1, LinkedList l2) {
//
//        if (l1 == null || l2 == null) {
//            return null;
//        }
//
//        LinkedList result = new LinkedList();
//
//        Node nodeL1 = l1.head;
//        Node nodeL2 = l2.head;
//
//        while(nodeL1 != null && nodeL2 != null) {
//            int sum = nodeL1.value + nodeL2.value;
//
//            Node summator = new Node(sum);
//            result.addInTail(summator);
//
//            nodeL1 = nodeL1.next;
//            nodeL2 = nodeL2.next;
//        }
//
//        if (nodeL1 != null) {
//            while (nodeL1 != null) {
//                int sum = nodeL1.value;
//
//                Node summator = new Node(sum);
//                result.addInTail(summator);
//
//                nodeL1 = nodeL1.next;
//            }
//        }
//
//        if (nodeL2 != null) {
//            while (nodeL2 != null) {
//                int sum = nodeL2.value;
//
//                Node summator = new Node(sum);
//                result.addInTail(summator);
//
//                nodeL2 = nodeL2.next;
//            }
//        }
//
//        return result;
//
//    }
//
//}
