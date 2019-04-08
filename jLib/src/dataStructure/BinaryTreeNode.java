package dataStructure;

public class BinaryTreeNode {//<E extends <Comparable <E>>
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTreeNode(int data)
	{
		this.data=data;
	}
	public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right)
	{
		this.data=data;
		this.left=left;
		this.right=right;
	}
	public void insert(BinaryTreeNode insert)
	{
		if (insert.data<this.data)
			if (left!=null)
				this.left.insert(insert);
			else
				this.left=insert;
		else
			if (right!=null)
				this.right.insert(insert);
			else
				this.right=insert;
	}
	
	public void print()
	{
		StringBuffer sb=new StringBuffer();
		BinaryTreeNode t=this;
		sb.append(t.getData());
		if (t.getLeft()!=null) sb.append(" L:"+t.getLeft().getData()); else sb.append(" L:null");
		if (t.getRight()!=null) sb.append(" R:"+t.getRight().getData());  else sb.append(" R:null");
		System.out.println(sb);
	}
}
