
public class BinarySearchTree {
	Node root;
	public BinarySearchTree() {
	
	}
	public void insert(int key) {
		insertHelp(key, root);
	}
	public void insertHelp(int key, Node parent) {
		Node newNode = new Node(key);
		if(root == null) {
			root = newNode;
			return;
		}
		if(key<parent.key) {
			if(parent.left == null) {
				parent.left = newNode;
				return;
			}else {
				insertHelp(key, parent.left);
			}
		}else {
			if(parent.right == null) {
				parent.right = newNode;
				return;
			}else {
				insertHelp(key, parent.right);
			}
		}
	}
	public void deleteTree() {
		deleteTreeHelp(this.root);
		this.root = null;
	}
	public Node deleteTreeHelp(Node root) {
		if(root == null) {
			return null;
		}
		root.right = deleteTreeHelp(root.right);
		root.left = deleteTreeHelp(root.left);
		//System.out.println(root.key);
		root = null;
		return root;
	}
	public void delete(int key) {
		root = deleteHelp(key, root);
	}
	public Node deleteHelp(int key, Node parent) {
		if(parent == null) {
			return null;
		}else if(key<parent.key) {	//If the key to delete is less than the current parent
			parent.left = deleteHelp(key,parent.left);	//the left child of the parent will change using recursion until it is found
		}else if(key>parent.key) {
			parent.right = deleteHelp(key,parent.right);//these two recursions are working their way down the tree, adjusting the parents
		}else { //if a match is found
			if(parent.left == null) { // and it has no left child
				return parent.right; //the new parent will be the right child
			}
			else if(parent.right == null) { //or if it has no right child
				return parent.left;//the new parent will be the left child
			}
			//if there are more two children
			parent.key = getMin(parent.right);//find the lowest value in the right(could also use the highest value in the left)
			parent.right = deleteHelp(parent.key, parent.right);//set the new parent using the key of the lowest value from the right and the current node to be replaced
		}
		return parent;
	}
	public int getMin(Node parent) {
		if(parent.left==null) {
			return parent.key;
		}
		return getMin(parent.left);
	}
	public void find(int key) {
		findHelp(key, root);
	}
	public void findHelp(int key, Node parent) {
		if(root == null) {
			System.out.println("The tree is empty!");
			return;
		}
		else if(parent==null) {
			System.out.println("Could NOT find " + key);
		}
		else if(key == parent.key) {
			System.out.println("Found " + key + "!");
			return;
		}
		else if(key<parent.key) {
			findHelp(key, parent.left);
		}else if(key>parent.key){
			findHelp(key, parent.right);
		}
	}
	public void traverseHelp(Node parent) {
		System.out.print("In order traversal [");
		traverseInOrder(parent);
		System.out.println("]");
	}
	public void traverseInOrder(Node parent) {
		if(parent == null) {
			return;
		}
		traverseInOrder(parent.left);
		System.out.print(parent.key + " ");
		traverseInOrder(parent.right);
	}
}
