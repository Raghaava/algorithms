package org.interview.preperation.binarytree;

import java.util.Stack;

public class IterativeSearch 
{
public static void main(String[] args) 
{
	IterativeSearch iterativeSearch = new IterativeSearch();	
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
	Node root = iterativeSearch.new Node(2);
	root.left = iterativeSearch.new Node(7);
	root.right = iterativeSearch.new Node(5);
	
	root.left.right = iterativeSearch.new Node(6);
	root.left.right.left = iterativeSearch.new Node(1);
	root.left.right.right = iterativeSearch.new Node(11);
	
	root.right.right = iterativeSearch.new Node(9);
	root.right.right.left = iterativeSearch.new Node(4);
	
	System.out.println(iterativeSearch.iterativeSearch(root,7));
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

public boolean iterativeSearch(Node node,int key)
{
	Stack<Node> stack = new Stack<Node>();
	
	boolean isDone = false;
	
	while(!isDone)
	{
		//process left tree
		//Tracks root to process right tree
		if(node != null)
		{
			stack.push(node);
			node = node.left;
		}
		else
		{
			//process root and right
			while(!stack.isEmpty())
			{
				node = stack.pop();
				System.out.println(node.key);
				
				if(key == node.key)
				{
					return true;
				}
				if(node.right != null)
				{
					node = node.right;
					break;
				}
				node = null;
			}
		}
		
		if(stack.isEmpty() && node == null)
		{
			isDone = true;
		}
	}
	
	return false;
}
}
