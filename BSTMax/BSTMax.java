
public class BSTMax {
	Node root;
	public BSTMax() {
		
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
			if(parent.left==null) {
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
	public int maxHeight(Node parent) {
		if(parent == null) {
			return -1;
		}
		return Math.max(maxHeight(parent.left)+1, maxHeight(parent.right)+1);
		/*int lftHeight = maxHeight(parent.left);
		int rtHeight = maxHeight(parent.right);
		if(lftHeight>rtHeight) {
			return lftHeight+1;
		}else {
			return rtHeight+1;
		}*/
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
}
