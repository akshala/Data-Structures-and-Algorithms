/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }   
        else if(head.next == null){
            return head;
        }
        else{
            ListNode a = head;
            ListNode aNext = head.next;
            ListNode b = head.next;
            while(b != null){
                a.next = b.next;
                if(a.next == null){
                    break;
                }              
                a = a.next;
                b.next = a.next;
                b = b.next;

            }
            a.next = aNext;
            return head;
        }
    }
    // public ListNode oddEvenList(ListNode head) {
    //     if(head == null){
    //         return null;
    //     }
    //     ListNode a = head;
    //     ListNode bhead = head.next;
    //     ListNode b = head.next;
    //     if(b == null){
    //         return head;
    //     }
    //     while(b != null){
    //         a.next = b.next;
    //         if(a.next == null) break;
    //         a = a.next;
    //         b.next = a.next;
    //         b = b.next;
    //     }
    //     a.next = bhead;
    //     return head;
    // }
}
