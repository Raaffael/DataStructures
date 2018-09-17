
public class a12main {
	static BSTMax max = new BSTMax();
	public static void main(String[] args) {
		maxSkewedTreeHeight(); //Demo in which each Node has no more than ONE child
		maxTreeHeight(); //Demo of regular(balanced) tree
	}
	public static void maxSkewedTreeHeight() {
		System.out.println("SKEWED TREE");
		max.insert(50);
		max.insert(45);
		max.insert(40);
		max.insert(36);
		max.insert(30);
		max.insert(26);
		max.insert(20);
		max.traverseHelp(max.root);
		System.out.println("Max tree height : " + max.maxHeight(max.root)+"\n\n");
		max.deleteTree();
	}
	public static void maxTreeHeight() {
		System.out.println("BALANCED TREE");
		max.insert(50);
		max.insert(55);
		max.insert(40);
		max.insert(36);
		max.insert(45);
		max.insert(57);
		max.insert(52);
		max.traverseHelp(max.root);
		System.out.println("Max tree height : " + max.maxHeight(max.root)+"\n\n");
		max.deleteTree();
	}

}
