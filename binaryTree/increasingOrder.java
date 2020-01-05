import java.util.Scanner;

class binaryTree{
	class Node {
		int data; 
		Node left; 
		Node right;

		/* Constructor */
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

	public Node insert(Node root, int value) {
		if (root == null)
			root = new Node (value);
		else {
			if (value < root.data)
			{
				root.left = insert (root.left, value);
			}
			else
			{
				root.right = insert (root.right, value);
			}
		}
		return root;
	}

	public static Node minBST(Node root) {
		if (root.left == null)
		{
			return root;
		}
		else
		{
			return minBST (root.left);
		}
	}

	public void inDisplay (Node root) {
		if (root!=null) {
			inDisplay (root.left);
			System.out.print (" " + root.data);
			inDisplay (root.right);
		}
	}

}

class increasingOrder{
	public static binaryTree bt = new binaryTree();
	public static binaryTree btNew = new binaryTree();
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int[] data = new int[9];
		for(int i=0; i<9; i++){
			bt.root = bt.insert(bt.root, s.nextInt());
		}
		binaryTree.Node base = bt.minBST(bt.root);
		btNew.root = btNew.insert(btNew.root, base.data);
		for(int i=0; i<9; i++){
			if(data[i] != base.data){
				btNew.root = bt.insert(btNew.root, data[i]);
			}
		}
		// bt.inDisplay(bt.root);
		btNew.inDisplay(btNew.root);
	}
}