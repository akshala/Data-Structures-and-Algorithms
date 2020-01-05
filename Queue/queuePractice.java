import java.util.Scanner;

class queue{
	class Nide{
		public int data;
		public Node link;
		Node(int d, Node p){
			data = d;

		}
		public void setLink(Node p){
			link = p;
		}
		public void setData(int d){
			data = d;
		}
		public int getData(){
			return data;
		}
		public Node getLink(){
			return link;
		}
	}
	public Node Front = null;
	public Node Rear = null;
	public int size = 0;

	public void enqueue(int value){
		Node nptr = new Node(value, null);
		if(Front == null){
			Front = nptr;
		}
		else{
			Rear.setLink(nptr);
		}
		Rear = nptr;
		size++;
	}

	public void dequeue(){
		if(Front == null){
			Rear = null;
		}
		int d = Front.getData();
		Front = Front.getLink();
		size--;
		return d;
	}
}