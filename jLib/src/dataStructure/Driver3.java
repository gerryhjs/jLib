package dataStructure;

public class Driver3 {
	public static void main(String args[])
	{
		
		int[] a=new int[5];
		int[] b=new int[5];
		a[0]=10;
		a[1]=8;
		a[2]=9;
		a[3]=6;
		a[4]=2;
		
		b[4]=1;
		int max;
		for (int i=4;i>=0;i--)
		{
			max=1;
			for(int j=i+1;j<=4;j++)
			{
				if ((a[i]>a[j]) && (max<b[j]+1))
				{
					max=b[j]+1;
				}
			} 
			b[i]=max;
		}
		max=1;
		for (int i=4;i>=0;i--)
		{
			System.out.println(i+":"+b[i]);
			if (b[i]>max)
			{
				max=b[i];
			}
		}
		System.out.print(max);
		/*
	 	BinarySearchTree bst=new BinarySearchTree();
		bst.insert(new BinaryTreeNode(50));
		bst.insert(new BinaryTreeNode(20));
		bst.insert(new BinaryTreeNode(15));
		bst.insert(new BinaryTreeNode(70));
		bst.insert(new BinaryTreeNode(30));
		bst.insert(new BinaryTreeNode(60));
		bst.insert(new BinaryTreeNode(80));
		bst.print();
		bst.remove(bst.find(20));
		System.out.println();
		bst.print();
		//bst.draw();*/
	}
}
