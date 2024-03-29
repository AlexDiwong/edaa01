package bst;

public class Treetest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		b.add(1);
		b.add(3);
		b.add(5);
		b.add(7);
		b.add(11);
		b.add(9);
		b.add(13);
//		b.add(10);
//		b.add(8);
//		b.add(30);
//		b.add(1);
//		b.add(17);
		System.out.println(b.height());
		System.out.println(b.size());
		b.printTree();
		BSTVisualizer wind = new BSTVisualizer("Test", 500, 500);
		wind.drawTree(b);
		b.rebuild();
		b.printTree();
		System.out.println(b.height());
		System.out.println(b.size());
		BSTVisualizer wind2 = new BSTVisualizer("Test2", 500, 500);
		wind2.drawTree(b);
		}

}
