/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if(a == null || b == null){
                return null;
            }
            else{
                int len_a = lenList(a);
                int len_b = lenList(b);
                if(len_a > len_b){
                    a = traverse(len_a - len_b, a);
                }
                else{
                    b = traverse(len_b - len_a, b);
                }
                while(a != null && b != null){
                    if(a == b){
                        return a;
                    }
                    a = a.next;
                    b = b.next;
                }
                return null;
            }
    }
    
        int lenList(ListNode ptr){
            int len = 0;
            while(ptr != null){
                len++;
                ptr = ptr.next;
            }
            return len;
        }

        ListNode traverse(int d, ListNode ptr){
            if(d == 0){
                return ptr;
            }
            while(d != 0){
                d--;
                ptr = ptr.next;
            }
            return ptr;
        }

        void printList(ListNode ptr){
            while(ptr != null){
                ptr = ptr.next;
            }
        }

    }