import java.util.Scanner;

class linkedList{
	class Node{
		public int data;
		public Node link;

		Node(int d, Node p){
			data = d;
			link = p;
		}
		public void setLink(Node p){
			link = p;
		}
		public Node getLink(){
			return link;
		}
		public void setData(int d){
			data = d;
		}
		public int getData(){
			return data;
		}
	}
	public Node Front = null;

	public void insert(int pos, int value){
		Node ptr = Front;
		Node nptr = new Node(value, null);
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
	public void delete(int value){
		Node prev = Front;
		Node curr = Front.getLink();
		Node nptr = new Node(value, null);
		if(Front.getData() == value){
			Front = Front.getLink();
		}
		while(curr != null){
			if(curr.getData() == value){
				nptr.setLink(curr.getLink());
				prev.setLink(nptr);
				break;
			}
			prev = curr;
			curr = curr.getLink();
		}
	}

	public void reOrder(){
		
	}
}

class reorderLinkedList{
	public static LinkedList linkedList = new LinkedList();
	public static void main(String[] args){

	}
}