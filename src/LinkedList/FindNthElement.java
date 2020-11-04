package LinkedList;

/**
 * Find nth node from the end of a Linked List
 */
public class FindNthElement {
    public static void main(String[] args) {
        ListNode<Integer> head = ListNode.getIntegerListNode(10);
        findNthElementFromLast(head , 5) ;
    }



    private static void findNthElementFromLast(ListNode<Integer> head, int n) {
        ListNode<Integer> temp = head ;
        ListNode<Integer> temp1 = head ;
        int count = 0;
        while(  count != n) {
            temp = temp.getNext();
            count++ ;
        }
        while(temp != null){
            temp = temp.getNext();
            temp1= temp1.getNext() ;

        }
        assert temp1 != null;
        System.out.println(temp1.getData());
    }
}
