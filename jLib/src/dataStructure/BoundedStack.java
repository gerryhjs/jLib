package dataStructure;

public class BoundedStack {
	private Object[] a;
	private int size;
	private int maxSize=1000;
	public BoundedStack()
	{
		//a=new Object[99999];
		a=new Object[maxSize];
		this.size=maxSize;
	}
	public BoundedStack(int size)
	{
		//a=new Object[99999];
		a=new Object[size];
		this.size=size;
	}
	public void push(Object ob) throws Exception
	{
		if ((depth()+1)<=size)
		{
		a[depth()]=ob;
			
		}
		else
		{
			throw new Exception("BreakStack!");	
		}
	}
	public Object pop() throws Exception
	{
		if (depth()>0)
		{
		Object t=a[depth()-1];
		a[depth()-1]=null;
		return t;
		}
		else
		{
			throw new Exception("NullStack!");
		}
	}
	public int depth()
	{
		int l=0;
		for (int i=0;i<size;i++)
			if (a[i]!=null) l++;
		return l;
	}
	/*
	public int getSize()
	{
		return this.size;
	}
	public void setSize(int size)
	{
		this.size=size;
	}
	*/
	public void print()
	{
		System.out.println("Print:");
		System.out.println("depth:"+depth());
		if (depth()==0) 	System.out.println("NULL!");
		for (int i=0;i<size;i++)
		{
			//if (a[i]!=null)
			{
			System.out.println("S"+i+":"+a[i]);
			}
		}
	}
	public Object getObject(int i)
	{
		return a[i];
	}
}
