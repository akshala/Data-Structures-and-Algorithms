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

	public int findTilt(Node root) {
        if(root == null){
            return 0;
        }
        if(root.right == null && root.left == null){
            return 0;
        }
        if(root.left == null){
            return root.right.data + sum(root.right);
        }
        else if(root.right == null){
            return root.left.data + sum(root.left);
        }
        else{
            return Math.abs((root.right.data + sum(root.right)) - (sum(root.left) + root.left.data));
        }
    }

    public int sum(Node root){
    	if(root == null){
    		return 0;
    	}
    	if(root.left == null && root.right == null){
    		return 0;
    	}
    	if(root.left == null){
    		return root.right.data + sum(root.right);
    	}
    	if(root.right == null){
    		return root.left.data + sum(root.left);
    	}
    	else{
    		return root.left.data + sum(root.left) + root.right.data + sum(root.right);
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

}

class binaryTilt{
	public static binaryTree bt = new binaryTree();
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		for(int i=0; i<5; i++){
			bt.root = bt.insert(bt.root, s.nextInt());
		}
		System.out.println(bt.sum(bt.root));
		System.out.println(bt.findTilt(bt.root));
	}
}