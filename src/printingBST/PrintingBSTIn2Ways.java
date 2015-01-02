package printingBST;

	import java.util.LinkedList;
import java.util.Queue;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


	public class PrintingBSTIn2Ways {
	public static void main(String[] args) {

			BST bst = BinSearchTree.makeTree();
			System.out.println("Printing nodes of the tree at every level");
			printNodesOnEveryLevel(bst);
			System.out.println();
			System.out.println("Printing Node Paths from root to leaf");
			printNodesFromRootToLeaf(bst);
			System.out.println();
			System.out.println(bst.maxDepth(bst.root));
			System.out.println(bst.balTree(bst.root));
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
