package dataStructure;

import java.util.ArrayList;

public class BinarySearchTree {  //<E extends <Comparable <E>>
	private BinaryTreeNode root=null;
	private ArrayList<BinaryTreeNode> tree=new ArrayList<BinaryTreeNode>();
	public void insert(BinaryTreeNode t)
	{
		tree.add(t);
		if (root!=null)
			root.insert(t);
		else
			root=t;
	}
	public void remove(BinaryTreeNode t)
	{
		if (t!=null)
		{
			if ((t.getLeft()==null) && (t.getRight()==null))
			{
				for (BinaryTreeNode scanner:tree)
				{
					if (scanner.getLeft()==t) scanner.setLeft(null);
					if (scanner.getRight()==t) scanner.setRight(null);
				}		
			}
			if ((t.getLeft()!=null) && (t.getRight()==null))
			{
				for (BinaryTreeNode scanner:tree)
				{
					if (scanner.getLeft()==t) scanner.setLeft(t.getLeft());
					if (scanner.getRight()==t) scanner.setRight(t.getLeft());
				}		
			}
			if ((t.getLeft()==null) && (t.getRight()!=null))
			{
				for (BinaryTreeNode scanner:tree)
				{
					if (scanner.getLeft()==t) scanner.setLeft(t.getRight());
					if (scanner.getRight()==t) scanner.setRight(t.getRight());
				}		
			}
			if ((t.getLeft()!=null) && (t.getRight()!=null))
			{
				for (BinaryTreeNode scanner:tree)
				{
					if (scanner.getLeft()==t) scanner.setLeft(t.getRight());
					if (scanner.getRight()==t) scanner.setRight(t.getRight());
				}
				ArrayList<BinaryTreeNode>  SearchTree=SearchOrder(t.getLeft());
				for (BinaryTreeNode scanner:SearchTree)
				{
					t.getRight().insert(scanner);
				}
			}
		}
	}
	public ArrayList<BinaryTreeNode> SearchOrder(BinaryTreeNode t)//����ĳһ�ض��ڵ��µ������ӽڵ�
	{
		ArrayList<BinaryTreeNode>  SearchTree=new ArrayList<BinaryTreeNode>();
		if (t!=null)
		{
			SearchTree.add(t);
			if (t.getLeft()!=null)
				SearchOrder(t.getLeft());
			if (t.getRight()!=null)
				SearchOrder(t.getLeft());
		}
		return SearchTree;
	}
	public void preOrder(BinaryTreeNode t)
	{
		if (t!=null)
		{
			t.print();
			preOrder(t.getLeft());
			preOrder(t.getRight());
		}
	}
	public void inOrder(BinaryTreeNode t)
	{
		if (t!=null)
		{
			preOrder(t.getLeft());
			t.print();
			preOrder(t.getRight());
		}
	}
	public void postOrder(BinaryTreeNode t)
	{
		if (t!=null)
		{
			preOrder(t.getLeft());
			preOrder(t.getRight());
			t.print();
		}
	}
	public BinaryTreeNode find(int data)
	{
		for (BinaryTreeNode scanner:tree)
		{
			if (scanner.getData()==data) return scanner;
		}
		return null;
	}
	public void print()
	{
		System.out.println("PreOreder:");
		preOrder(root);
		System.out.println("InOreder:");
		inOrder(root);
		System.out.println("PostOreder:");
		postOrder(root);
	}
	/*
	public void draw() 
	{
		System.out.println("        "+root.getData()+"        ");
		System.out.println("    "+root.getLeft().getData()+"    "+root.getRight().getData()+"    ");
		System.out.println("  "+root.getLeft().getLeft().getData()+"  "+root.getLeft().getRight().getData()+"  "+root.getRight().getLeft().getData()+"  "+root.getRight().getRight().getData());
	}
*/
}
