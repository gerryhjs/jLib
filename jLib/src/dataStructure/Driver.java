package dataStructure;

public class Driver {

	public static void main(String args[]) 
	{
	BoundedStack bs=new BoundedStack(3);
	BoundedQueue bq=new BoundedQueue(3);
	Object ob1="1";
	Object ob2="2";
	int i=0;
	int t=0;
	int f=0;
	int p=0;
	try {
		System.out.println("Stack Test:");
		i++;
		System.out.print("Checkpoint"+i+" push()");
		bs.push(ob1);
		if ((bs.getObject(0)=="1")  &&(bs.getObject(1)==null)&&(bs.getObject(2)==null))
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
		System.out.print("Checkpoint"+i+" push()");
		bs.push(ob2);
		if ((bs.getObject(0)=="1")  &&(bs.getObject(1)=="2")&&(bs.getObject(2)==null))
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
		System.out.print("Checkpoint"+i+" depth()");
		if (bs.depth()==2)
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
		System.out.print("Checkpoint"+i+" pop()");
		bs.pop();
		if ((bs.getObject(0)=="1")  &&(bs.getObject(1)==null)&&(bs.getObject(2)==null))
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
		System.out.print("Checkpoint"+i+" pop()");
		bs.pop();
		if ((bs.getObject(0)==null)  &&(bs.getObject(1)==null)&&(bs.getObject(2)==null))
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
		System.out.print("Checkpoint"+i+" depth()");
		if (bs.depth()==0)
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
		System.out.print("Checkpoint"+i+" ��ջpop�쳣����");
		BoundedStack bs1=new BoundedStack();
		bs1.pop();
		{
		System.out.println(":WrongAnswer");	
		f++;
		}	
		
	} catch (Exception e) {
		if (i==7)
		{
			System.out.println(":Accepted");
			t++;
		}
		else
		{
			System.out.println(":RuntimeError");	
			f++;
		}
	}
	try{
		i++;
		System.out.print("Checkpoint"+i+" ��ջpush�쳣����");
		BoundedStack bs2=new BoundedStack(1);
		bs2.push(ob1);
		bs2.push(ob1);
		{
		System.out.println(":WrongAnswer");	
		f++;
		}	
		
	}catch (Exception e) {
		if (i==8)
		{
			System.out.println(":Accepted");
			t++;
		}
		else
		{
			System.out.println(":RuntimeError");	
			f++;
		}
	}
	p=t*5;
	System.out.println("Total:8"+" Success:"+t+ " Fail:"+f);
	
	//---------------------------
	System.out.println("Queue Test:");
	try {
		i=0;
		t=0;
		f=0;
		
		i++;
		System.out.print("Checkpoint"+i+" insert()");
		bq.insert(ob1);
		if ((bq.getObject(0)=="1")  &&(bq.getObject(1)==null)&&(bq.getObject(2)==null))
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
		bq.insert(ob2);
		if ((bq.getObject(0)=="1")  &&(bq.getObject(1)=="2")&&(bq.getObject(2)==null))
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
		if (bq.length()==2)
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
		System.out.print("Checkpoint"+i+" remove()");
		bq.remove();
		if ((bq.getObject(0)==null)  &&(bq.getObject(1)=="2")&&(bq.getObject(2)==null))
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
		bq.insert(ob1);
		if ((bq.getObject(0)==null)  &&(bq.getObject(1)=="2")&&(bq.getObject(2)=="1"))
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
		if (bq.length()==2)
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
		System.out.print("Checkpoint"+i+" insert()*");
		bq.insert(ob1);
		if ((bq.getObject(0)=="1")  &&(bq.getObject(1)=="2")&&(bq.getObject(2)=="1"))
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
		System.out.print("Checkpoint"+i+" remove()*");
		bq.remove();
		if ((bq.getObject(0)=="1")  &&(bq.getObject(1)==null)&&(bq.getObject(2)=="1"))
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
		System.out.print("Checkpoint"+i+" remove()*");
		bq.remove();
		if ((bq.getObject(0)=="1")  &&(bq.getObject(1)==null)&&(bq.getObject(2)==null))
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
		System.out.print("Checkpoint"+i+" length()*");
		if (bq.length()==1)
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
		System.out.print("Checkpoint"+i+" �ն���remove�쳣����");
		BoundedQueue bq1=new BoundedQueue();
		bq1.remove();
		{
		System.out.println(":WrongAnswer");	
		f++;
		}	
		
	} catch (Exception e) {
		if (i==11)
		{
			System.out.println(":Accepted");
			t++;
		}
		else
		{
			System.out.println(":RuntimeError");	
			f++;
		}
	}
	try{
		i++;
		System.out.print("Checkpoint"+i+" ������insert�쳣����");
		BoundedQueue bq2=new BoundedQueue(1);
		bq2.insert(ob1);
		bq2.insert(ob1);
		{
		System.out.println(":WrongAnswer");	
		f++;
		}	
		
	}catch (Exception e) {
		if (i==12)
		{
			System.out.println(":Accepted");
			t++;
		}
		else
		{
			System.out.println(":RuntimeError");	
			f++;
		}
		
	}
	System.out.println("Total:12"+" Success:"+t+ " Fail:"+f);
	p+=t*5;
	System.out.println("Finsh:"+p+"%");
	}
	
	
	
}
