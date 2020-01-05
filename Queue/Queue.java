import java.util.Scanner;

class queue{
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
    public static Node Rear = null;
    public static int size;

    public void enqueue(int val){
    	Node nptr = new Node(val);
    	if(Rear == null){
    		Front = nptr;
    	}
    	else{
    		Rear.setLink(nptr);
    	}
    	Rear = nptr;
    	size++;
    }

    public int dequeue(){
    	int d = Front.getData();
    	Front = Front.getLink();
    	if(Front == null){
    		Rear = null;
    	}
    	size--;
    	return d;
    }

    public int getFront(){
    	return Front.getData();
    }

    public int getRear(){
    	return Rear.getData();
    }

    public int getSize(){
    	return size;
    }

    public boolean isEmpty(){
    	if(size <= 0){
    		return true;
    	}
    	return false;
    }

    public void print(){
        Node ptr = Front;
        while(ptr != null){
            System.out.print(ptr.getData() + " ");
            ptr = ptr.getLink();
        }
    }
}

class Queue{
    public static queue q = new queue();
    public static void main(String[] args){
        q.enqueue(1);
        q.print();
        System.out.println();
        q.enqueue(2);
        q.print();
        System.out.println();
        q.enqueue(3);
        q.print();
        System.out.println();
        q.dequeue();
        q.print();
        System.out.println();
    }
}
