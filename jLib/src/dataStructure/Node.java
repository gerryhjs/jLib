package dataStructure;

public class Node {
private Object data=null;
private Node next=null;
	public Node(Object data)
	{
		this.setData(data);
		this.setNext(null);
	}
	public Node(Object data, Node next) throws Exception
	{
		//Node scanner = null;
		this.setData(data);
		/*
		int index = 0;
		while ((scanner=scanner.getNext())!=null) 
			{
				index++;
				if (index>=100) throw new Exception("RoundNode!");
			}
			*/
		this.setNext(next);
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public void removeNext()
	{
		if (this.next!=null)
		{
			this.next=this.next.next;
		}
	}
	public void insert(Node insert) throws Exception
	{
		insert.setNext(this.next);
		this.next=insert;
		/*
		Node scanner = insert;
		int index = 0;
		while ((scanner=scanner.getNext())!=null) 
			{
				index++;
				if (index>=100) throw new Exception("RoundNode!");
			}
		*/
	
	}
	public void append(Node append)
	{
		Node scanner=this;
		while (scanner.next!=null) scanner=scanner.next;
		scanner.setNext(append);
	}
	public void print()
	{
		System.out.println("data:"+data+" next:"+next);
	}
	public int length()
	{
		int length=1;
		Node scanner=this;
		while ((scanner=scanner.getNext())!=null) length++; 
		return length;
	}
	public void printAll()
	{
		Node scanner=this;
		scanner.print();
		while ((scanner=scanner.getNext())!=null) scanner.print();
	}
}
