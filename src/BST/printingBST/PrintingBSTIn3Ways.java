package BST.printingBST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

	public class PrintingBSTIn3Ways {
	public static void main(String[] args) {

			BST bst = BinSearchTree.makeTree();
			// print LCA between 2 nodes
			System.out.println("Recursively LCA of 20 and 85 is: "+recursiveLCA(bst.root,new Node(20),new Node(85)));
			System.out.println("Iteratively LCA of 20 and 85 is: "+iterativeLCA(bst.root,new Node(20),new Node(85)));
			
			
			
			System.out.println("Printing nodes of the tree at every level");
			printNodesOnEveryLevel(bst);
			System.out.println();
			System.out.println("Printing Node Paths from root to leaf");
			printNodesFromRootToLeaf(bst);
			System.out.println();
			System.out.println("Function to print the rows of a binary tree, terminating each row with a carriage return");
			printRowsTerminatingEachRowWithCarriageReturn(bst);
			System.out.println();
			System.out.println("Max depth of the tree is: ");
			System.out.println(bst.maxDepth(bst.root));
			System.out.println("Tree is balanced?");
			System.out.println(bst.balTree(bst.root));
			
			// BFS Traversal
			System.out.println("BFS Traversal of the tree is: ");
			bfs(bst);
		
			// DFS Traversal
			System.out.println("DFS Traversal of the ree is: ");
			dfs(bst);
		}



	private static int iterativeLCA(Node root, Node a, Node b) {
		
		if(root==null||a==null||b==null)
			return -1;
		
		while(root!=null){
			if(a.data<root.data && b.data<root.data)
				root=root.lchild;
			else if(a.data>root.data && b.data>root.data)
				root=root.lchild;
			else break;
		}
		return root.data;
	}



	private static int recursiveLCA(Node root, Node a, Node b) {
		if(root==null||a==null||b==null)
			return -1;
		if(a.data<root.data && b.data<root.data)
			recursiveLCA(root.lchild,a,b);
		if(a.data>root.data && b.data>root.data)
			recursiveLCA(root.rchild,a,b);
		return root.data;
	}



	private static void printNodesFromRootToLeaf(BST bst) {
		int[] path = new int[1000];
		printNodesFromRootToLeafAlgorithm(bst.root,0,path);
	}

	private static void printNodesFromRootToLeafAlgorithm(Node node, int pathLength,	int[] path) {
		
		path[pathLength] = node.data;
		pathLength++;
		
		if(node.lchild==null && node.rchild==null)
			printPaths(path,pathLength);
		else{
			if(node.lchild!=null)
			printNodesFromRootToLeafAlgorithm(node.lchild, pathLength, path);
			if(node.rchild!=null)
			printNodesFromRootToLeafAlgorithm(node.rchild, pathLength, path);
		}
		
	}

	private static void printPaths(int[] path, int pathLength) {
		for(int i=0;i<pathLength;i++)
			System.out.print(path[i]+" ");
		System.out.println();
	}
	
	private static void printNodesOnEveryLevel(BST bst) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(bst.root);
		while(!queue.isEmpty()){
			Node n = queue.poll();
			System.out.print(n.data+" ");
			if(n.lchild!=null)
				queue.add(n.lchild);
			if(n.rchild!=null)
				queue.add(n.rchild);
			}
		System.out.println();
		}
	
	private static void printRowsTerminatingEachRowWithCarriageReturn(BST bst){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(bst.root);
		queue.add(null);  // use null as 'end of certain depth' marker
		while(queue.size()>1 || queue.peek()!=null){
			Node node=queue.remove();
			if(node!=null){
				System.out.print(node.data+" ");
				if(node.lchild!=null)
					queue.add(node.lchild);
				if(node.rchild!=null)
					queue.add(node.rchild);
			}
			else{// node==null
				System.out.println("\r");
				queue.add(null);  // use null as 'end of certain depth' marker
			}
			
		}
	}
	private static void bfs(BST bst) {      // BEST method for BFS Traversal
		// Similar to the method which prints nodes at every level of the BST
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(bst.root);
		while(!queue.isEmpty()){
			Node n = queue.poll();
			System.out.print(n.data+" ");
			if(n.lchild!=null)
				queue.add(n.lchild);
			if(n.rchild!=null)
				queue.add(n.rchild);
		}
		System.out.println();
	}
	 
	private static void dfs(BST bst) {     // BEST method for DFS Traversal
		Stack<Node> stack = new Stack<Node>();
		stack.push(bst.root);
		while(!stack.isEmpty()){
			Node n = stack.pop();
			System.out.print(n.data+" ");
			if(n.rchild!=null)//First insert the RCHILD into STACK, reason being, the tree will be printed from LEFT TO RIGHT
	// However, even if LCHILD into STACK is inserted first, it is NOT worng, just that the tree will be printed from RIGHT TO LEFT
				stack.push(n.rchild);
			if(n.lchild!=null)  // Then insert LCHILD
				stack.push(n.lchild);
			
		}
		System.out.println();
	}
	}
	class Node{
		public int data;
		public Node lchild;
		public Node rchild;
		
		public Node(int data) {
		this.data=data;
		lchild=null;
		rchild=null;
		}
	}

	class BST {
	public Node root=null;

		public void addNode(Node n){
			if(root==null)
			{
				root=n;
				System.out.println(n.data+" added as the root to the tree");
			}
			else{
				
				Node current=root;
				Node parent;
				while(true){
					parent=current;
					
					if(n.data<current.data){
						current=current.lchild;
						if(current==null){
							parent.lchild=n;
							return;
						}
					}
					else{
						current=current.rchild;
						if(current==null){
							parent.rchild=n;
							return;
						}
					}
					
				}
			}
			
		}
		public void display(){
			display(root);
			System.out.println();
		}
		
		public void display(Node n){
			Node tempNode=n;
			if(tempNode==null)
				return;
			else{
			    display(tempNode.lchild);
				System.out.print(tempNode.data+" ");
				display(tempNode.rchild);
			}
		}
		public boolean isBST(){
			return isBST(root); 
		}
		public boolean isBST(Node n){
			Node prev;
			if(n==null)
				return false;
			prev=n;
				if(n.data>=prev.data)
					return true;
			
			return (isBST(n.lchild)&&isBST(n.rchild));
			}
				
			
		
	public int size(){
		return size(root);
	}

	public int size(Node node){
			if(node==null)
				return 0;
			else{
				int ltree=size(node.lchild);
				int rtree=size(node.rchild);
				return (ltree+1+rtree);			
			}
	}

	public int maxDepth(){
		return maxDepth(root);
	}
	public int maxDepth(Node node){
		if(node==null)
			return 0;
		else{
			int ltree=maxDepth(node.lchild);
			int rtree=maxDepth(node.rchild);
			
			if(ltree<rtree)
				return rtree+1;
			else
				return ltree+1;
		}
	}

	public boolean balTree(){
		return balTree(root);
	}
	public boolean balTree(Node node){
		if(node==null)
			return true;
		else{
			int lsize=maxDepth(root.lchild);
			int rsize=maxDepth(root.rchild);
			
			if(Math.abs(lsize-rsize)>1)
				return false;
			else return true;
			
		}
	}
	}
	class BinSearchTree{
		
		public static BST makeTree() {
			BST myTree=new BST();
			System.out.println("Adding the elemets");
			myTree.addNode(new Node(40));
			myTree.addNode(new Node(50));
			myTree.addNode(new Node(30));
			myTree.addNode(new Node(80));
			myTree.addNode(new Node(20));
			myTree.addNode(new Node(10));
			myTree.addNode(new Node(5));
			myTree.addNode(new Node(85));
			myTree.addNode(new Node(35));
			myTree.addNode(new Node(45));
			myTree.addNode(new Node(32));
			myTree.addNode(new Node(15));
			myTree.addNode(new Node(38));
			myTree.addNode(new Node(36));
			myTree.display();
			
			
			return myTree;
		}
	}