package org.interview.preperation.binarytree;

public class LeftsumSubtree {

	public static void main(String[] args) 
	{
		LeftsumSubtree leftsumSubtree = new LeftsumSubtree();	
		
		/**
		 *                   (2)
		 *               /         \
		 *             (7)         (5)
		 *           /     \           \
		 *        null      (6)         (9)  
		 *                /     \     /     \
		 *             (1)      (11) (4)   null
		 *                        ^            
		 *                        |
		 *                       Max
		 */
		Node root = leftsumSubtree.new Node(2);
		root.left = leftsumSubtree.new Node(7);
		root.right = leftsumSubtree.new Node(5);
		
		root.left.right = leftsumSubtree.new Node(6);
		root.left.right.left = leftsumSubtree.new Node(1);
		root.left.right.right = leftsumSubtree.new Node(11);
		
		root.right.right = leftsumSubtree.new Node(9);
		root.right.right.left = leftsumSubtree.new Node(4);
		
		leftsumSubtree.computeSum(root);
		leftsumSubtree.display(root);
	}

	class Node
	{
	  int key;
	  Node left;
	  Node right;
	  
	  Node(int key)
	  {
		  this.key = key;
	  }
	}

	public int computeSum(Node node)
	{
		if(node == null)
		{
			return 0;
		}
	    int lsum = computeSum(node.left);
	    int rsum = computeSum(node.right);
	    
	    node.key = node.key + lsum;
	    
	    return node.key+rsum;
	}
	
	public void display(Node node)
	{
		if(node != null)
		{
	      display(node.left);
	      System.out.println(node.key);
	      display(node.right);
	    }
	}
}