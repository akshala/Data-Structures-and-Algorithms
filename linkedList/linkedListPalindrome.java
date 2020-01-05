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

    public int[] printList(){
        Node ptr = Front;
        int i = 0;
        int[] a = new int[5];
        while(ptr != null){
            a[i] = ptr.getData();
            ptr = ptr.getLink();
            i++;
        }
        return a;
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

}

class linkedListPalindrome{
    public static LinkedList linkedList = new LinkedList();
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        for(int i=0; i<5; i++){
            linkedList.insertEnd(s.nextInt());
        }
        int[] straight = linkedList.printList();
        linkedList.reverse();
        int[] reverse = linkedList.printList();
        if(Arrays.equals(straight, reverse)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}