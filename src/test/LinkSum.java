package test;

import java.util.List;

public class LinkSum {

    /**
     * Definition for singly-linked list.*/
     public static class ListNode {
         int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            int rem=0;

            int a,b;
            int s=0;

            ListNode tl1=l1;
            ListNode tl2=l2;
            ListNode r=new ListNode();
            a=tl1.val;
            b=tl2.val;
            s=a+b;
            r.val=s%10;
            rem=s/10;
ListNode head = r;
            ListNode temp ;
            tl1= tl1.next;
            tl2=tl2.next;

            while(tl1!=null || tl2!=null){

                temp= new ListNode();

                if(tl1!=null){
                    a=tl1.val;
                    tl1=tl1.next;
                }
                else
                    a=0;

                if(tl2!=null){
                    b=tl2.val;
                    tl2=tl2.next;
                }

                else
                    b=0;
                s=a+b+rem;

                temp.val = (s)%10;
                rem=s/10;

                r.next=temp;

                r=r.next;

            }


            if(rem!=0)
            {
                temp = new ListNode(rem);
                r.next=temp;
            }


            return head;
        }

    public static void main(String[] args) {
        ListNode l1= new ListNode(9);
        ListNode l2= new ListNode(9);
        ListNode l3= new ListNode(9);
        ListNode l7= new ListNode(9);
        ListNode l8= new ListNode(9);
        ListNode l9= new ListNode(9);
        ListNode l10= new ListNode(9);

        l1.next=l2;
        l2.next=l3;
        l3.next=l7;
        l7.next=l8;
        l8.next=l9;
        l9.next=l10;


        ListNode l4= new ListNode(9);
        ListNode l5= new ListNode(9);
        ListNode l6= new ListNode(9);
        ListNode l11= new ListNode(9);

        l4.next=l5;
        l5.next=l6;
        l6.next=l11;

        LinkSum a = new LinkSum();
       ListNode l= a.addTwoNumbers(l1,l4);

        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }




    }

    }

