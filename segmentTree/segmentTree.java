import java.util.Scanner;

class binaryTree{
	class Node {
		int data; 
		Node left; 
		Node right;

		public Node() {
			this.data = 0; 
			left = null; 
			right = null;
		}
		public Node (int data) {
			this.data = data;
			left = null;
			right = null;
		}

	}
	public static Node root = null;

	public void build()