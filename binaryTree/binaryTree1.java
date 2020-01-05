class Node {
	int data; Node left; Node right;

/* Constructor */
	public Node() {
		this.data = 0; left = null; right = null;
	}
	public Node (int data) {
	this.data = data;
	left = null;
	right = null;
	}
}

/* preorder display */
public void display (Node root) {

	if (root!=null) {
		System.out.print (" " + root.data);

		display (root.left);
		display (root.right);
	}
}

/* inorder display */
public void display (Node root) {

	if (root!=null) {
		display (root.left);
		System.out.print (" " + root.data);
		display (root.right);
	}
}

public int count (Node root) {

	if (root==null)
		return 0;
	else
		return 1 + count (root.left) + count (root.right);
}

/* height of binary tree */
public int height (Node root) {

	if (root==null)
		return 0;
	else
	{
		return 1 + max (height (root.left), height (root.right));
	}
}

private Node Copy(Node root)
{
	if (root == null) {
		return null;
	}
	Node copy = new Node(root.data);
	copy.left = Copy(root.left);
	copy.right = Copy(root.right);
	return copy;
}