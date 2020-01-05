import java.util.Scanner;

class CircularLinkedList(){

	public void insertInEmpty(int value){
		Node New = new Node(value);
		Rear = New;
		Rear.setLink(Rear);
	}

	public void insert(int value){
		Node New = new Node(value);
		New.setLink(Cur);
		Prev.setLink(New);
	}

	public void insertEnd(int value){
		Node New = new Node(value);
		New.setLink(Cur);
		Prev.setLink(New);
		Rear = New;
	}

	public void delete{
		prev.setLink(Cur.getLink());
	}

	public void print(Node Rear){
		Node Cur;
		if(Rear != NULL){
		Cur = Rear.getlink();
		do{
			print node data;
			Cur = Cur.getlink();
		}while(Cur != Rear.getlink());
	}
}