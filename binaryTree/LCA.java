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

	public Node insert (Node root, int value) {
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

	public Node lca(Node root, int n1, int n2){
		if(root == null){
			return null;
		}
		else{
			if(root.data > n1 && root.data > n2){
				return lca(root.left, n1, n2);
			}
			else if(root.data < n1 && root.data < n2){
				return lca(root.right, n1, n2);
			}
			return root;
		}
	}

}

class LCA{
	public static binaryTree bt = new binaryTree();
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		for(int i=0; i<9; i++){
			bt.root = bt.insert(bt.root, s.nextInt());
		}
		binaryTree.Node ancestor = bt.lca(bt.root, 2, 4);
		System.out.println(ancestor.data);
	}
}