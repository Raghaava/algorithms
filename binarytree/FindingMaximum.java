package org.interview.preperation.binarytree;

public class FindingMaximum 
{
public static void main(String[] args) {
	FindingMaximum max = new FindingMaximum();
	
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
	Node root = max.new Node(2);
	root.left = max.new Node(7);
	root.right = max.new Node(5);
	
	root.left.right = max.new Node(6);
	root.left.right.left = max.new Node(1);
	root.left.right.right = max.new Node(11);
	
	root.right.right = max.new Node(9);
	root.right.right.left = max.new Node(4);
	
	System.out.println(max.findMax(root));
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

public int findMax(Node root)
{
	if(root == null)
	{
		return Integer.MIN_VALUE;
	}
	
	int res = root.key;
	
	int left = findMax(root.left);
	
	int right = findMax(root.right);
	
	if(res < left)
	{
		res = left;
	}
	
	if(res < right)
	{
		res = right;
	}
	
	return res;
}
}

