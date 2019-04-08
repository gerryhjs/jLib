package dataStructure;
public class DoubleLinkedList {
	public DoubleLinkedNode first;
	public  DoubleLinkedNode scanner;
	public DoubleLinkedNode last;
	
	public DoubleLinkedList(DoubleLinkedNode first)
	{
		this.first=first;
		this.last=null;
	}
	
	public DoubleLinkedList(DoubleLinkedNode first,DoubleLinkedNode last)
	{
		this.first=first;
		this.last=last;
	}
	
	
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		scanner=first;
		s.append(scanner.getData()+"\n");
		while(((scanner=scanner.getNext())!=null))// ||(scanner==last))
			s.append(scanner.getData()+"\n");
			//System.out.println(scanner.getData());
		
		return s.toString();
	}
	
	public Object getObject(int index)
	{
		DoubleLinkedNode scanner=first;
		for (int i=1;i<=index;i++)
		{
			scanner=scanner.getNext();
		}
		return	scanner;
	}
	public int length()
	{
		return first.lengthAfter();
	}
	
	public void append(DoubleLinkedNode next)
	{
		first.append(next);
		//last=next;
		//last.setNext(next);
	}
	public void delete(DoubleLinkedNode n)
	{
		DoubleLinkedNode scanner=first;
		while (scanner.getNext()!=n)
			scanner=scanner.getNext();
		scanner.setNext(scanner.getNext().getNext());
	}
}
