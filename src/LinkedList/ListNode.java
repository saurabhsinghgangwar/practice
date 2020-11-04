package LinkedList;

public class ListNode<T> {
    private  T data ;
    private ListNode<T> next ;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public static ListNode<Integer> getIntegerListNode(int n) {
        ListNode<Integer> processor = new ListNode<>() ;
        processor.setData(1);
        processor.setNext(null);
        ListNode<Integer> head = processor ;
        ListNode<Integer> temp ;
        for(int i =2 ; i< n ; i++){
            temp = new ListNode<>() ;
            temp.setData(i);
            temp.setNext(null);
            processor.setNext(temp);
            processor  = temp ;
        }
        return head;
    }

    public void printList(ListNode<T> node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
