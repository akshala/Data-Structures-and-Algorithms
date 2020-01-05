import java.util.Scanner;

class DoublyLinkedList{
	class Node{
		public int data;
        public Node prev;
        public Node next;

        Node(){             // simple node
            data =0;
            next = null;
        }

        Node(int d){        //a node with a given value
            data = d;
            next = null;
        }

        Node(int d, Node n){   // node with given value and refernce
            data = d;
            next = n;
        }

        Node(int d, Node n, Node p){   // node with given value and refernce
            data = d;
            next = n;
            prev = p;
        }
        public void setNext(Node n){
            next = n;
        }

        public Node getNext(){
            return next;
        }

        public void setPrev(Node n){
        	prev = n;
        }

        public Node getPrev(){
        	return prev;
        }

        public void setData(int d){
            data = d;
        }

        public int getData(){
            return data;
        }
	}
	public static Node Front = null;

	public void insertFront(int value){
        Node nptr = new Node (value);
        nptr.setPrev(null);
        if (Front == null){
            Front = nptr;        
        }
        else{
            nptr.setNext(Front);
        }
        Front = nptr;
    }

    public void insert(int value, Node node_prev){
    	Node nptr = new Node(value, null);
    	nptr.setNext(node_prev.getNext());
    	node_prev.setNext(nptr);
    	nptr.setPrev(node_prev);
    	if(nptr.getNext() != null){
    		Node n = nptr.getNext();
    		n.setPrev(nptr);
    	}
    }

    public void insertEnd(int value){
    	Node nptr = new Node(value, null);
    	Node ptr = Front;
    	if(Front == null){
    		nptr.setPrev(null);
    		Front = nptr;
    		return;
    	}
    	while (ptr.getNext() != null){
    		ptr = ptr.getNext();
    	}
    	ptr.setNext(nptr);
    	ptr.setPrev(ptr);
    }

    public void printListForward(){
        Node ptr = Front;
        while(ptr != null){
            System.out.println(ptr.getData() + " ");
            ptr = ptr.getNext();
        }
    }

    public void printListBackward(){
    	Node ptr = Front;
    	while (ptr.getNext() != null){
    		ptr = ptr.getNext();
    	}

        while(ptr != null){
            System.out.println(ptr.getData() + " ");
            ptr = ptr.getPrev();
        }
    }

    public void deleteFront(){
        Node ptr = Front.getNext();
        Front = ptr;
        ptr.setPrev(null);
    }

    public void deleteEnd(){
        Node prev = Front;
        Node curr = Front.getNext();
        while(curr.getNext() != null){
            prev = curr;
            curr = curr.getNext();
        }
        prev.setNext(null);
    }


    public static void delete(int d){
        if(Front.getData() == d){
            Front = Front.getLink();
        }
        else{
            Node prev = Front;
            Node curr = Front.getNext();
            while(curr.getData() != d){
                if(curr.getData() == d){
                    prev = curr;
                    curr = curr.getNext(); 
                }
            }
            prev.setNext(curr.getNext());
        }
    }
	
}

public class doublyLinkedListTest{
	public static DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

	public static void main(String[] args){
		doublyLinkedList.insertFront(1);
	}
}