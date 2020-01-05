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
	/* preorder display */

	public void PreOrderDisplay (Node root) {
		if (root!=null) {
			System.out.print (" " + root.data);
			PreOrderDisplay (root.left);
			PreOrderDisplay (root.right);
		}
	}

	public void inDisplay (Node root) {
		if (root!=null) {
			inDisplay (root.left);
			System.out.print (" " + root.data);
			inDisplay (root.right);
		}
	}

	public void PostDisplay (Node root) {
		if (root!=null) {
			PostDisplay (root.left);
			PostDisplay (root.right);
			System.out.print (" " + root.data);
		}
	}

	public int count (Node root) {
		if (root==null)
		{
			return 0;
		}
		else
		{
			return 1 + count (root.left) + count (root.right); 
		}
	}

	/* height of binary tree */

	public int height (Node root) {
		if (root==null)
		{
			return 0;
		}
		else
		{
			return 1 + max (height (root.left), height (root.right));

		}
	}

	public int max(int x, int y){
		int maxNum = x;
		if(y > x){
			maxNum = y;
		}
		return maxNum;
	}

	public Node Copy(Node root)
	{
		if (root == null) {
			return null;
		}
		Node copy = new Node(root.data);
		copy.left = Copy(root.left);
		copy.right = Copy(root.right);
		return copy;
	}

	public boolean searchBST (Node root, int target) {
		Node current = root;
		// while (current != null) {
		if(current == null){
			return false;
		}
		if (current.data == target)
		{
			return true;	
		}
		else if (current.data > target)
		{
			return searchBST (current.left, target);	
		}
		else
		{
			return searchBST (current.right, target);
		}
		// }
		return false;
	}

	public Node search (Node root, int target) {

		Node current = root;
		// while (current != null) {
		if(current == null){
			return null;
		}
		if (current.data == target)
		{
			return current;
		}
		else if (current.data > target)
		{
			return search (current.left, target);
		}
		else
		{
			return search (current.right, target);
		}
		// }
		return null;
	}

	public int smallest (Node root) {
		if (root.left == null)
		{
			return (root.data);
		}
		else
		{
			return smallest (root.left);
		}
	}

	public static Node minBST (Node root) {
		if (root.left == null)
		{
			return root;
		}
		else
		{
			return minBST (root.left);
		}
	}

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

	public static boolean BST (Node root, int min, int max) {
		// if all nodes satisfy bst
		if (root == null)
		{
			return true;
		}
		return (root.data > min && root.data < max && BST (root.left, min, root.data) && BST (root.right, root.data, max));
	}

	public static Node delete (Node root, int value)
	{
		if (root == null)
		{
			return null;
		}
		if (root.data > value)
		{
			root.left = delete (root.left, value);
		}
		else if (root.data < value)
		{
			root.right = delete (root.right, value);
		}
		else
		{
		// if node has two children
			if (root.left != null && root.right != null)
			{
				Node temp = root;
				// Finding minimum element from right
				Node minRight = minBST (temp.right);
				// Replacing current with min node from right subtree
				root.data = minRight.data;
				// Deleting minimum node from right now
				delete (root.right, minRight.data);
			}
			// if node has only the left child replace by left child
			else if (root.left != null)
			{
				root = root.left;
			}
			// if node has only the right child replace by right child
			else if (root.right != null)
			{
				root = root.right;
			}
			// if node has no child (it is a leaf ) simply delete
			else
			{
				root = null;
			}
		}
		return root;
	}

	public Node leftRotate(Node x){
		Node y = x.right;
		Node t = x.left;
		y.left = x;
		x.right = t;
		return y;
	}

	public Node rightRotate(Node y){
		Node x = y.left;
		Node t = y.right;
		x.right = y;
		y.left = t;
		return x;
	}

	public int heightDiff(Node r){
		if(r == null){
			return 0;
		}
		return height(r.left) - height(r.right);
	}
	
	public static void avl(Node root, int value){
		Node n = insert(root, value);
		int diff = heightDiff(n);
		if(diff > 1 && root.data < root.left.data){ //left left
			return rightRotate(n);
		}
		if(diff < -1 && root.data > root.right.data){ //right right
			return leftRotate(n);
		}
		if(diff > 1 && root.data > root.left.data){ //left right
			n.left = leftRotate(n);
			return rightRotate(n);
		}
		if(diff < -1 && root.data < root.right.data){ //right left
			n.right = rightRotate(n);
			return leftRotate(n);
		}
		return n;
	}

}


class binaryTreeTest{
	public static binaryTree bt = new binaryTree();
	public static void main(String[] args){
		bt.root = bt.insert(bt.root, 1);
		bt.root = bt.insert(bt.root, 2);
		bt.root = bt.insert(bt.root, 3);
		bt.root = bt.insert(bt.root, 4);
		// System.out.println();
		// System.out.println(bt.count(bt.root));
		bt.root = bt.delete(bt.root, 4);
		bt.inDisplay(bt.root);
		// System.out.println(bt.searchBST(bt.root, 2));
	}
}