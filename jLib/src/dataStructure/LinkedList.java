package dataStructure;
public class LinkedList {
	public  Node first;
	public  Node scanner;
	public  Node last;
	
	public LinkedList(Node first)
	{
		this.first=first;
		this.last=null;
	}
	
	public LinkedList(Node first,Node last)
	{
		this.first=first;
		this.last=last;
	}
	
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		scanner=first;
		s.append(scanner.getData()+"\n");
		while (((scanner=scanner.getNext())!=null)) //||(scanner==last))
			s.append(scanner.getData()+"\n");
			//System.out.println(scanner.getData());
		
		return s.toString();
	}
	
	public Object getObject(int index)
	{
		Node scanner=first;
		for (int i=1;i<=index;i++)
		{
			scanner=scanner.getNext();
		}
		return	scanner;
	}
	public int length()
	{
		return first.length();
	}
	
	public void append(Node next)
	{
		//first.append(next);
		last=next;
		last.setNext(next);
	}
	public void delete(Node n)
	{
		Node scanner=first;
		while (scanner.getNext()!=n)
			scanner=scanner.getNext();
		scanner.setNext(scanner.getNext().getNext());
	}
}
