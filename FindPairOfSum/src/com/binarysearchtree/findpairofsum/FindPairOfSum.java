package com.binarysearchtree.findpairofsum;

import java.util.HashSet;
import java.util.Set;

public class FindPairOfSum 
{
	static Node root;
	static class Node
	 {
		int data;
		Node left;
		Node right;
		
		public Node(int data)
		{
			super();
			this.data=data;
		}
	 }
	
	FindPairOfSum()
	{
		super();
	    root= null;
	}
	
	public static void main(String[] args)
	{
		FindPairOfSum tree = new FindPairOfSum();
		tree.insertKey(40);
		tree.insertKey(20);
		tree.insertKey(60);
		tree.insertKey(10);
		tree.insertKey(30);
		tree.insertKey(50);
		tree.insertKey(70);
		int sum=10;
		tree.findPairWithGivenSum(root,sum);
	}

	private void insertKey(int data)
	{
		root=insert(root,data);
	}
	Node insert(Node root, int data)
	{
		if(root==null)
		{
			root=new Node(data);
			return root;
		}
		if(data<root.data)
		{
			root.left=insert(root.left,data);
		}else if(data>root.data)
		{
			root.right=insert(root.right,data);
		}
		return root;
	}
	
	void findPairWithGivenSum(Node root, int sum)
	{
		Set<Integer> set = new HashSet<Integer>();
		if(!findPairUtil(root,sum,set)) 
		{
			System.out.println("Nodes are not found.");
		}
	}
	
	private boolean findPairUtil(Node root, int sum, Set<Integer> set)
	{
		if (root==null)
		{
			return false;
		}
		if(findPairUtil(root.left,sum,set))
		{
			return true;
		}
		if(set.contains(sum-root.data))
		{
			System.out.println("Pair is ("+(sum-root.data)+","+root.data+")");
			return true;
		}else
		{
			set.add(root.data);
		}
		return(findPairUtil(root.right,sum,set));
	}

}
