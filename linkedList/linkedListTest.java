import java.util.Scanner;

class LinkedList{
    class Node{
        public int data;
        public Node link;

        Node(){             // simple node
            data =0;
            link = null;
        }

        Node(int n){        //a node with a given value
            data = n;
            link = null;
        }

        Node(int n, Node p){   // node with given value and refernce
            data = n;
            link = p;
        }
        public void setLink(Node n){
            link = n;
        }

        public void setData(int d){
            data = d;
        }

        public Node getLink(){
            return link;
        }

        public int getData(){
            return data;
        }
    }
    public static Node Front = null;

    public void insertFront(int value){
        Node nptr = new Node (value);
        if (Front == null){
            Front = nptr;        
        }
        else{
            nptr.setLink(Front);
        }
        Front = nptr;
    }

    public void insertEnd(int value){
        Node nptr = new Node(value);
        Node ptr = Front;
        if (ptr == null) {
            Front = nptr;
            return;
        }
        while(ptr.getLink() != null){
            ptr = ptr.getLink();
        }
        ptr.setLink(nptr);
    }

    //     public static void insertInEmpty(int value){
    //         Node nptr = new Node(value, null);
    //         if(Front == null){
    //             Front = nptr;
    //         }
    //     }

    //     public static void insertEndGeneral(int value){
    //         Node nptr = new Node(value, null);
    //         if(Front == null){
    //             Front = nptr;
    //         }
    //         else{
    //             ptr = Front;
    //             while(ptr.getLink() != null){
    //                 ptr = ptr.getLink();
    //             }
    //             ptr.setLink(nptr);
    //         }
    //     }

    public void printList(){
        Node ptr = Front;
        while(ptr != null){
            System.out.println(ptr.getData() + " ");
            ptr = ptr.getLink();
        }
    }

    //     public static void printRecur(Node ptr){
    //         while(ptr != null){
    //             System.out.println(ptr.getData() + " ");
    //             printRecur(ptr.getLink());
    //         }            
    //     }

    public void countNode(){
        Node ptr = Front;
        int count = 1;
        while(ptr.getLink() != null){
            count++;
            ptr = ptr.getLink();
        }
        System.out.println("count " + count);
    }

    //     public static void countRecur(Node ptr){
    //         if(ptr == null){
    //             return 0;
    //         }
    //         return 1 + countRecur(ptr.getLink());
    //     }

    public void insert(int value, int pos){
        // insertion after pos
        // can't insert at start
        Node nptr = new Node(value, null);
        Node ptr = Front;
        int count = 0;
        while(ptr != null){
            if(count == pos){
                Node temp = ptr.getLink();
                ptr.setLink(nptr);
                nptr.setLink(temp);
                break;
            }
            ptr = ptr.getLink();
            count++;
        }
    }

    public void deleteFront(){
        Node ptr = Front.getLink();
        Front = ptr;
    }

    public void deleteEnd(){
        Node prev = Front;
        Node curr = Front.getLink();
        while(curr.getLink() != null){
            prev = curr;
            curr = curr.getLink();
        }
        prev.setLink(null);
    }

    //     public static void deleteSingleNode(){

    //     }

    public static void delete(int d){
        if(Front.getData() == d){
            Front = Front.getLink();
        }
        else{
            Node prev = Front;
            Node curr = Front.getLink();
            while(curr.getData() != d){
                if(curr.getData() == d){
                    prev = curr;
                    curr = curr.getLink(); 
                }
            }
            prev.setLink(curr.getLink());
        }
    }

    public void reverse(){
        Node ptr = Front;
        Node n1 = null;
        while(ptr != null){
            int d = ptr.getData();
            Node nptr = new Node(d, n1);
            n1 = nptr;
            ptr = ptr.getLink();
        }
        Front = n1;
    }

    public Node reverseInPlace(Node curr){
        Node next = null;
        Node prev = null;
        while(curr != null){
            next = curr.getLink();
            curr.setLink(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node reverseRecur (Node head); {
        if (head == null || head.getLink == null){
            return head;
        }
        Node next = head.getLink;
        head.getLink = null;
        Node rest = reverseRecur(next);
        next.setLink(head);
        return rest;
    }
}

public class linkedListTest{
    public static LinkedList linkedList = new LinkedList();

    public static void main(String[] args){
        // linkedList list = new linkedList();
        // LinkedList.Node nptr1 = linkedList.new Node(50, null);
        // LinkedList.Node nptr2 = linkedList.new Node(30, null);
        // Front = nptr1;
        // Front.setLink(nptr2);
        // print();
        // linkedList.insertFront(10);
        linkedList.insertEnd(10);
        linkedList.insertEnd(5);
        linkedList.insertEnd(15);
        linkedList.insert(1,0);
        linkedList.printList();
        // linkedList.countNode();
        // linkedList.delete(1);
        // linkedList.printList();
        // linkedList.reverse();
        // linkedList.printList();
        System.out.println();
        linkedList.Front = linkedList.reverseInPlace(linkedList.Front);
        linkedList.printList();
    }
}
