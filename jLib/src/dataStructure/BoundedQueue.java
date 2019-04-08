package dataStructure;

public class BoundedQueue {
	private Object[] a;
	private int size;
	private int maxSize=1000;
	private int ff=0;//firstfree
	public BoundedQueue()
	{
		//a=new Object[99999];
		a=new Object[maxSize];
		this.size=maxSize;
	}
	public BoundedQueue(int size)
	{
		//a=new Object[99999];	
		a=new Object[size];
		this.size=size;
	}
	public void insert(Object ob) throws Exception
	{
		if ((length()+1)<=size)
		{
			a[ff]=ob;
			ff++;
			if (ff==size) ff=0;
			return;
		}
		else
		{
		throw new Exception("BreakQueue!");	
		}
	}
	public void remove() throws Exception
	{
		if (length()!=0) 	
		{
			for (int i=ff;i<ff+size;i++)
			{
				int ix;
				if (i>=size) ix=i-size; else ix=i;
				if (a[ix]!=null)
				{
					a[ix]=null;
					return;
				}
			}
		}
		else
		{
			throw new Exception("NullQueue!");	
		}
	}
	public int length()
	{
		int l=0;
		for (int i=0;i<size;i++)
			if (a[i]!=null) l++;
		return l;
	}
	public Object getFront()
	{
		for (int i=ff;i<ff+size;i++)
		{
			int ix;
			if (i>=size) ix=i-size; else ix=i;
			if (a[ix]!=null)
			{
				return a[ix];
			}
		}
		return null;
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
		System.out.println("length:"+length());
		if (length()==0) 	System.out.println("NULL!");
		for (int i=0;i<size;i++)
		{
			//if (a[i]!=null)
			{
			System.out.println("Q"+i+":"+a[i]);
			}
		}
	}
	public Object getObject(int i)
	{
		return a[i];
	}
}
