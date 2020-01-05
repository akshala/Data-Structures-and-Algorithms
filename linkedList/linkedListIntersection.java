import java.util.Scanner;
import java.util.Arrays;

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

    public void insertEnd(int value){
        //in General
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

    public int len(Node ptr){
        int len = 0;
        while(ptr != null){
            len++;
            ptr = ptr.getLink();
        }
        return len;
    }

    public Node traverse(int d, Node ptr){
        if(d == 0){
            return ptr;
        }
        while(d != 0){
            d--;
            ptr = ptr.getLink();
        }
        return ptr;
    }

    public void printList(Node ptr){
        while(ptr != null){
            System.out.println(ptr.getData() + " ");
            ptr = ptr.getLink();
        }
    }

    public Node intersection(Node a, Node b){
        if(a == null || b == null){
            return null;
        }
        else{
            int len_a = len(a);
            int len_b = len(b);
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
                a = a.getLink();
                b = b.getLink();
            }
            return null;
        }
    }

}

class linkedListIntersection{
    public static LinkedList linkedList1 = new LinkedList();
    public static LinkedList linkedList2 = new LinkedList();
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        for(int i=0; i<5; i++){
            linkedList1.insertEnd(s.nextInt());
        }
        for(int i=0; i<3; i++){
            linkedList2.insertEnd(s.nextInt());
        }
        LinkedList.Node a = linkedList1.Front;
        LinkedList.Node b = linkedList2.Front;

        if(a == null || b == null){
            System.out.println("null");
        }
        else{
            int flag = 0;
            int len_a = 5;
            int len_b = 3;
            if(len_a > len_b){
                a = linkedList1.traverse(len_a - len_b, a);
                // System.out.println(a);
                // linkedList1.printList(a);
                linkedList2.printList(b);
                System.out.println("yes");
            }
            else{
                b = linkedList2.traverse(len_b - len_a, b);
            }
            while(a != null && b != null){
                // System.out.println(a.getData());
                // System.out.println(b.getData());
                if(a == b){
                    System.out.println("yes");
                    flag = 1;
                    break;
                }
                a = a.getLink();
                b = b.getLink();
            }
            if(flag == 0){           
                System.out.println("null");
            }
        }

    }
}