package LinkedList;

import javax.xml.soap.Node;

/**
 * Flip the list from nth node e.g. :
 * Input 1 2 3 4 5 6 K 3
 * result 3 2 1 6 5 4
 */
public class FlipListFromNth {
    public static void main(String[] args) {
        ListNode<Integer> head = ListNode.getIntegerListNode(10);
        System.out.println("Question: ");
        head.printList(head);
        System.out.println();
        flipList(head , 5) ;
    }

    private static void flipList(ListNode<Integer> head, int n) {
        ListNode<Integer> temp = head ;
        int count = 0;
        while(  count != n-1 ) {
            temp = temp.getNext();
            count++ ;
        }


        ListNode<Integer> second =  reverse(temp.getNext()) ;
        temp.setNext(null);
        ListNode<Integer> first =reverse(head) ;

        ListNode<Integer> result =first ;
        while (first.getNext() != null){
            first = first.getNext() ;
        }
        first.setNext(second);
        System.out.println("Answer");
        result.printList(result);

    }

    private static ListNode<Integer> reverse(ListNode<Integer> node)
    {
        ListNode<Integer> prev = null;
        ListNode<Integer> current = node;
        ListNode<Integer> next;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev) ;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }


}
