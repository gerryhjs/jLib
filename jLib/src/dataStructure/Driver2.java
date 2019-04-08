package dataStructure;

public class Driver2 {
	public static void main(String args[]) throws Exception 
	{
		DoubleLinkedNode n1=new DoubleLinkedNode("aaa");
		DoubleLinkedNode n2=new DoubleLinkedNode("bbb");
		DoubleLinkedNode n3=new DoubleLinkedNode("ccc");
		int i=0;
		int t=0;
		int f=0;
		i++;
		System.out.print("Checkpoint"+i+" create()");
		DoubleLinkedList ll=new DoubleLinkedList(n1);
		if (ll.getObject(0)==n1)
		{
		System.out.println(":Accepted");
		t++;
		}
		else
		{
		System.out.println(":WrongAnswer");	
		f++;
		}

		//System.out.println(ll.toString());
		
		i++;
		System.out.print("Checkpoint"+i+" append()");
		
		ll.append(n2);
		ll.append(n3);
		
		if ((ll.getObject(0)==n1) && (ll.getObject(1)==n2) && (ll.getObject(2)==n3))
		{
		System.out.println(":Accepted");
		t++;
		}
		else
		{
		System.out.println(":WrongAnswer");	
		f++;
		}
		
		i++;
		System.out.print("Checkpoint"+i+" length()");
		//
		if (ll.length()==3)
		{
		System.out.println(":Accepted");
		t++;
		}
		else
		{
		System.out.println(":WrongAnswer");	
		f++;
		}
		
		i++;
		System.out.print("Checkpoint"+i+" removeNext()");
		n1.removeNext();
		if (ll.getObject(1)==n3)
		{
		System.out.println(":Accepted");
		t++;
		}
		else
		{
		System.out.println(":WrongAnswer");	
		f++;
		}
		
		i++;
		System.out.print("Checkpoint"+i+" insert()");
		n1.insertAfter(n2);
		if (ll.getObject(1)==n2)
		{
		System.out.println(":Accepted");
		t++;
		}
		else
		{
		System.out.println(":WrongAnswer");	
		f++;
		}
		
		
		System.out.println("\n"+ll.toString());
		//System.out.println(ll.length());
		System.out.println("Total:"+i+" Success:"+t+ " Fail:"+f);
	}
}
