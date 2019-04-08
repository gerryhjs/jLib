package dataStructure;

public class DoubleLinkedNode {
private Object data=null;
private DoubleLinkedNode next=null;
private DoubleLinkedNode previous=null;

	public DoubleLinkedNode(Object data)
	{
		this.setData(data);
		this.setNext(null);
		this.setPrevious(null);
	}
	public DoubleLinkedNode(Object data, DoubleLinkedNode next, DoubleLinkedNode previous) throws Exception
	{
		this.setData(data);
		this.setNext(next);
		this.setPrevious(previous);
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public DoubleLinkedNode getNext() {
		return next;
	}
	public void setNext(DoubleLinkedNode next) {
		this.next = next;
	}
	public void removeNext()
	{
		if (this.next!=null)
		{
			this.next=this.next.getNext();
		}
	}
	public void insertAfter(DoubleLinkedNode insert)
	{
		insert.setNext(this.next);
		insert.setPrevious(this);
		if (this.next!=null) this.next.setPrevious(insert);
		this.setNext(insert);
	}
	
	public void insertBefore(DoubleLinkedNode insert)
	{
		insert.setNext(this);
		insert.setPrevious(this.previous);
		if (this.previous!=null) this.previous.setNext(insert);
		this.setPrevious(insert);
	}
	
	public void append(DoubleLinkedNode append)
	{
		DoubleLinkedNode scanner=this;
		while (scanner.next!=null) scanner=scanner.next;
		scanner.setNext(append);
	}
	public void print()
	{
		System.out.println("data:"+data+" next:"+next);
	}
	public int lengthAfter()
	{
		int length=1;
		DoubleLinkedNode scanner=this;
		while ((scanner=scanner.getNext())!=null) length++; 
		return length;
	}
	
	public int lengthBefore()
	{
		int length=1;
		DoubleLinkedNode scanner=this;
		while ((scanner=scanner.getPrevious())!=null) length++; 
		return length;
	}
	
	
	public void printAll()
	{
		DoubleLinkedNode scanner=this;
		scanner.print();
		while ((scanner=scanner.getNext())!=null) scanner.print();
	}
	
	public void setPrevious(DoubleLinkedNode previous)
	{
		this.previous=previous;
	}
	public DoubleLinkedNode getPrevious()
	{
		return previous;
	}

}
