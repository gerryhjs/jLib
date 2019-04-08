package basic_Algorithm;


import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;


public class Map {
	private ArrayList<EdgeNode> EdgeNode=new ArrayList<EdgeNode>();
	private ArrayList<VertexNode> VertexNode=new ArrayList<VertexNode>();
	public ArrayList<VertexNode> route=new ArrayList<VertexNode>();
	public ArrayList<ArrayList<VertexNode>> solution=new ArrayList<ArrayList<VertexNode>>();
	public JLabel label;
	public int VertexNum;
	public VertexNode start;
	public VertexNode end;
	private int DEFAULT_MAX_INT=32768;
	
	public void init(int n,boolean dir)
	{

		if (n<=0) return;
		while(true)
		{
			this.destory();
			for (int i=0;i<n;i++)
				this.insertVertex(new VertexNode(String.valueOf((char)(i+65))));
			int max= n*n;
			if (!dir) max=(int)(max*0.4);
			for (int i=0;i<max;i++)
			{
				boolean flag=true;
				while (flag)
				{
					int fromIndex=((int) (Math.random()*n));
					int toIndex=((int) (Math.random()*n));
					if (fromIndex==toIndex) 
							continue;
					
					VertexNode from=VertexNode.get(fromIndex);
					VertexNode to=VertexNode.get(toIndex);
					if (getDistance(from,to)>=DEFAULT_MAX_INT)
					{
					EdgeNode en=new EdgeNode(from.getName(),to.getName(),((int) (Math.random()*20+1)));
					en.beginIndex=fromIndex;
					en.endIndex=toIndex;
					if (dir) 
						en.setDirect();
						
					this.insertEdge(en);
					flag=false;
					}
				}
			}
			if (!dir) return;
			VertexNode head=VertexNode.get(0);
	
			if (check(head)) return;
		}
	}
	public boolean check(VertexNode head)
	{
		/*
		for(VertexNode Scanner:VertexNode)
		{
			if (!Scanner.getName().equals(head.getName()))
			{
				this.init(head,Scanner);
				if ((Dijkstrax(head,Scanner))>=DEFAULT_MAX_INT) return false;
			}
		}
		return true;
		*/
		init(head,head);
		long checkLen=Round(head);
		Notice(String.valueOf(checkLen));
		return (checkLen<DEFAULT_MAX_INT);
	}
	public void destory()
	{
		EdgeNode=new ArrayList<EdgeNode>();
		VertexNode=new ArrayList<VertexNode>();
		
	}

	public void BFS(VertexNode head)
	{
		ArrayList <VertexNode> list=new ArrayList<VertexNode>();
		ArrayList <VertexNode> temp=new ArrayList<VertexNode>();
		list.add(head);
		Notice(head.getName());
		temp.add(head);
		head.been=true;
		while(list.size()>0)
		{
			temp=new ArrayList<VertexNode>();
			for (VertexNode Scanner:list)
			{
				for (String Scanner2:getVertexFrom(Scanner.getName()))
				{
					VertexNode next=getVertex(Scanner2);
					if (!next.been) 
					{
						Notice(next.getName());
						temp.add(next);
						next.been=true;
					}
				}
			Scanner.been=true;	
			}
			list=temp;
		}
	 }  
		
	
	public void DFS(VertexNode head)
	{
		head.been=true;	
		if (!route.contains(head))
		{
		Notice(head.getName());
		route.add(head);
		}
		//Notice(head.getName()+":"+String.valueOf(getVertexFrom(head.getName())));
		boolean flag=true;
		for (String Scanner:getVertexFrom(head.getName()))
		{	
			VertexNode next=getVertex(Scanner);
			if (!next.been)
			{
				flag=false;
				DFS(next);
			}
		}
		if (flag) return;
		head.been=false;
	}
	public void insertVertex(VertexNode vn)
	{
		if (!containVertex(VertexNode,vn)) VertexNode.add(vn);
	}
	public void removeVertex(VertexNode vn)
	{
		if (containVertex(VertexNode,vn))
		{
			ArrayList<VertexNode> temp=VertexNode;
			VertexNode=new ArrayList<VertexNode>();
			for (VertexNode Scanner:temp)
			{
				if (!Scanner.getName().equals(vn.getName())) VertexNode.add(Scanner);
			}
		}
	}

	public void insertEdge(EdgeNode en)
	{
		if (!containEdge(EdgeNode,en)) EdgeNode.add(en);
	}
	public void removeEdge(EdgeNode en)
	{
		if (containEdge(EdgeNode,en))
		{
			ArrayList<EdgeNode> temp=EdgeNode;
			EdgeNode=new ArrayList<EdgeNode>();
			for (EdgeNode Scanner:temp)
			{
				if (!Scanner.getDetail().equals(en.getDetail())) EdgeNode.add(Scanner);
			}
		}
	}
	public ArrayList<EdgeNode> getEdgeNode() {
		return EdgeNode;
	}
	public void setEdgeNode(ArrayList<EdgeNode> edgeNode) {
		EdgeNode = edgeNode;
	}
	public ArrayList<VertexNode> getVertexNode() {
		return VertexNode;
	}
	public void setVertexNode(ArrayList<VertexNode> vertexNode) {
		VertexNode = vertexNode;
	}
	
	public static boolean containVertex(ArrayList<VertexNode> VertexNode,VertexNode find)
	{
		for (VertexNode Scanner:VertexNode)
			if (Scanner.getName().equals(find.getName())) return true;
		return false;
	}
	public static boolean containEdge(ArrayList<EdgeNode> EdgeNode,EdgeNode find)
	{
		for (EdgeNode Scanner:EdgeNode)
		{
			if ((Scanner.getFrom().equals(find.getFrom())) && (Scanner.getTo().equals(find.getTo()))) return true;
			if ((Scanner.getFrom().equals(find.getTo())) && (Scanner.getTo().equals(find.getFrom()))) return true;
		}
		return false;
	}
	public VertexNode getVertex(String name)
	{
		for (VertexNode Scanner:VertexNode)
			if (Scanner.getName().equals(name)) return Scanner;
		return null;
	}
	public EdgeNode getEdge(String detail)
	{
		for (EdgeNode Scanner:EdgeNode)
			if (Scanner.getDetail().equals(detail)) return Scanner;
		return null;
	}
	public EdgeNode getEdge(String from,String to)
	{
		for (EdgeNode Scanner:EdgeNode)
		{
			if (!Scanner.isDirect())
				if ((Scanner.getFrom().equals(to)) && (Scanner.getTo().equals(from))) return Scanner;
			if ((Scanner.getFrom().equals(from)) && (Scanner.getTo().equals(to))) return Scanner;
		}
		return null;
	}
	public ArrayList<String> getVertexFrom(String from)
	{
		ArrayList<String> ans=new ArrayList<String>();
		for (EdgeNode Scanner:EdgeNode)
		{
			if (!Scanner.getFrom().equals(Scanner.getTo()))
			{
				if (!Scanner.isDirect())
					if ((Scanner.getTo().equals(from))) ans.add(Scanner.getFrom());
				if ((Scanner.getFrom().equals(from))) ans.add(Scanner.getTo());
			}
		}
		return ans;
	}
	public void init(VertexNode start,VertexNode end)
	{
		for (VertexNode Scanner:VertexNode)
		{
			if (Scanner!=null)
			{
			Scanner.min=DEFAULT_MAX_INT;
			Scanner.been=false;
			Scanner.from=null;
			Scanner.to=new ArrayList<VertexNode>();
			}
		}
		start.min=0;
		route=new ArrayList<VertexNode>();
		solution=new ArrayList<ArrayList<VertexNode>>();
		this.start=start;
		this.end=end;
	}
	public VertexNode getGreedyVertex(VertexNode head,ArrayList<String> list)
	{
		int min=DEFAULT_MAX_INT;
		String result="";
		for (String Scanner:list)
		{
			if(getEdge(head.getName(),Scanner).getWeight()<min)
			{
				result=Scanner;
				min=getEdge(head.getName(),Scanner).getWeight();
			}
		}
		return getVertex(result);
	}
	public static boolean contain(ArrayList<VertexNode> List,VertexNode find)
	{
		for (VertexNode scanner:List)
			if (scanner.toString().equals(find.toString())) return true;
		return false;
	}
	public long Round(VertexNode start)
	{
		Round(start,start);
		long min=DEFAULT_MAX_INT;
		for (ArrayList<VertexNode> Scanner:solution)
		{
			//Notice(VertexArrayToPrint(Scanner));
			if (VertexArrayLen(Scanner)<min) 
				{
				min=VertexArrayLen(Scanner);
				route=Scanner;
				}
		}
		Notice("=======================");						
		return VertexArrayLen(route);
	}
	public void Round(VertexNode start,VertexNode end)
	{
		//Notice("Now Searching on"+start.getName());
		//Notice()
		start.been=true;
		{
			boolean flag=true;
			for (VertexNode Scanner:VertexNode)
				if (!Scanner.been) flag=false;
			if (flag)
			{
				end.from=start;
				solution.add(getResult2());
				//return;
			}

		}
		for (VertexNode Scanner:VertexNode)
		{
			if (Scanner!=null)
			{
				if ((!Scanner.been)) //z&& (Scanner!=start) )//&& (!contain(start.to,Scanner)))
				{
				Scanner.from=start;
				Round(Scanner,end);
				}
			}
		}
		start.been=false;
		//return;
	}
	
	//start.to.add(Scanner);
	//Scanner.to.add(start);
	//start.to.remove(Scanner);
	public long Greedy(VertexNode start,VertexNode end)
	{
		start.been=true;
		//Notice("Now calc:"+start.getName()+":"+start.min+"��"+end.getName()+":"+end.min);
		ArrayList<String> list=getVertexFrom(start.getName());
		String s="Now calc:"+start.getName()+":";
		for (String Scanner:list)
			if (getVertex(Scanner)!=null) if (!getVertex(Scanner).been) s+=Scanner;
		Notice(s);
		s="";
		for (VertexNode Scanner:VertexNode)
			s+=Scanner.getName()+":"+Scanner.min+" ";
		Notice(s);
		boolean Greedy=false;
		for (String Scanner:list)
		{
			VertexNode next;
			if (!Greedy)
			{
		    next=getGreedyVertex(start,list);
			Greedy=true;		
			}
			else next=getVertex(Scanner);
			if (next!=null)
			if (!next.been)
			{
				int len=(start.min+getEdge(start.getName(),next.getName()).getWeight());
				if (len<next.min)
				{
					Notice("Next calc:"+start.getName()+":"+start.min+ "\ufffd\ufffd" +next.getName()+":"+next.min);
					next.min=len;
					next.from=start;
					Greedy(next,end);
				}
			}
		}
		start.been=false;
		return VertexArrayLen(getResult());
		
	}
	
	public long BruteForce(VertexNode start,VertexNode end)
	{

		start.been=true;
		boolean flag=true;
		//Notice("Now calc:"+start.getName()+":"+start.min+"&#xfffd;&#xfffd;"+end.getName()+":"+end.min);
		ArrayList<String> list=getVertexFrom(start.getName());
		String s="Now calc:"+start.getName()+":";
		for (String Scanner:list)
			if (getVertex(Scanner)!=null) if (!getVertex(Scanner).been) s+=Scanner;
		Notice(s);
		s="";
		for (VertexNode Scanner:VertexNode)
			s+=Scanner.getName()+":"+Scanner.min+" ";
		Notice(s);
		for (String Scanner:list)
		{
			VertexNode next=getVertex(Scanner);
			if (next!=null)
			if (!next.been)
			{
				int len=(start.min+getEdge(start.getName(),next.getName()).getWeight());
				if (len<next.min)
				{
					Notice("Next calc:"+start.getName()+":"+start.min+ "\ufffd\ufffd" +next.getName()+":"+next.min);
					next.min=len;
					next.from=start;
					BruteForce(next,end);
					flag=true;
				}
				else
				{
					flag=false;
				}
			}
			else
			{
				//route.remove(start);
			}
		}
		if (flag) 
			{
			start.been=false;
			//route.remove(start);
			}
	
		return VertexArrayLen(getResult());
	}
	public long Dijkstra(VertexNode start,VertexNode end)//OP WAY for print
	{
		if (start==null) return DEFAULT_MAX_INT;
		Notice("Now calc:"+start.getName()+":"+start.min+ "\ufffd\ufffd" +end.getName()+":"+end.min);
		String s="";
		for (VertexNode Scanner:VertexNode)
			s+=Scanner.getName()+":"+Scanner.min+" ";
		Notice(s);

		s="Now calc:"+start.getName()+":";
		for (String Scanner:getVertexFrom(start.getName()))
			if (getVertex(Scanner)!=null) if (!getVertex(Scanner).been) s+=Scanner;
		Notice(s);
		start.been=true;
		for (EdgeNode Scanner:EdgeNode)
		{
			if (Scanner.getFrom().equals(start.getName()))
			{
				VertexNode next=getVertex(Scanner.getTo());
				if (next!=null)
				{
				int len=(start.min+Scanner.getWeight());
				if (len<next.min)
				next.min=len;
				}
			}
			else if (Scanner.getTo().equals(start.getName()))
			{
				VertexNode next=getVertex(Scanner.getFrom());
				if (next!=null)
				{
				int len=(start.min+Scanner.getWeight());
				if (len<next.min)
				next.min=len;
				}
			}
		}
		int min=DEFAULT_MAX_INT;
		VertexNode next = null;
		s="";
		for (VertexNode scanner:VertexNode)
			if (scanner!=null)
				s+=(scanner.getName()+ ":" +scanner.min+";");
		Notice(s);
		for (VertexNode scanner:VertexNode)
		{
			if ((scanner!=null) && (scanner.min>start.min))
			{
			if (scanner.min<min) 
				{
				next=scanner;
				next.from=start;
				}
			}
		}
		if (next==null) return DEFAULT_MAX_INT;
		if (next.getName().equals(end.getName()))
			{
			//Notice(VertexArrayToPrint(route));
			return end.min;
			}
		
		Dijkstra(next,end);
		
		return VertexArrayLen(getResult());
	}
	
	
	
	
	////////////////////////////////
	public long Dijkstrax(VertexNode start,VertexNode end) //
	{
		if (start==null) return DEFAULT_MAX_INT;
		start.been=true;
		for (EdgeNode Scanner:EdgeNode)
		{
			if (Scanner.getFrom().equals(start.getName()))
			{
				VertexNode next=getVertex(Scanner.getTo());
				if (next!=null)
				{
				int len=(start.min+Scanner.getWeight());
				if (len<next.min)
				next.min=len;
				}
			}
			else if (Scanner.getTo().equals(start.getName()))
			{
				VertexNode next=getVertex(Scanner.getFrom());
				if (next!=null)
				{
				int len=(start.min+Scanner.getWeight());
				if (len<next.min)
				next.min=len;
				}
			}
		}
		int min=DEFAULT_MAX_INT;
		VertexNode next = null;
		for (VertexNode scanner:VertexNode)
		{
			if ((scanner!=null) && (scanner.min>start.min))
			{
			if (scanner.min<min) 
				{
				next=scanner;
				next.from=start;
				}
			}
		}
		if (next==null) return DEFAULT_MAX_INT;
		if (next.getName().equals(end.getName()))
			{
			//Notice(VertexArrayToPrint(route));
			return end.min;
			}
		Dijkstrax(next,end);
		
		return VertexArrayLen(getResult());
	}
	public int getDistance(VertexNode v1,VertexNode v2)
	{
		if (Objects.equals(v1.getName(), v2.getName())) return 0;
		for (EdgeNode Scanner:EdgeNode)
		{
			if (Scanner!=null)
			{
			if ((Objects.equals(Scanner.getFrom(), v1.getName())) && (Objects.equals(Scanner.getTo(), v2.getName())))
				return Scanner.getWeight();
			if (!Scanner.isDirect())
			if ((Objects.equals(Scanner.getFrom(), v2.getName())) && (Objects.equals(Scanner.getTo(), v1.getName())))
				return Scanner.getWeight();
			}
		}
		return DEFAULT_MAX_INT;
	}
	
	public long  VertexArrayLen(ArrayList<VertexNode> input)
	{
		long sumLen=0;
		VertexNode last=null;
		//VertexNode first=input.get(0);
		for (VertexNode scanner:input)
		{
			//if (last!=null) if (print) System.out.println(getDistance(last,scanner));
			if (last!=null) sumLen+=getDistance(last,scanner);
			last=scanner;
		}
		//sumLen+=getDistance(last,first);
		return sumLen;
		
	}

	public String VertexArrayToPrint(ArrayList<VertexNode> input)
	{
		String s = "";
		//long sumLen=0;
		//VertexNode last;
		//VertexNode first=input.get(0);
		int i=0;
		for (VertexNode scanner:input)
		{
		
			//if (last!=null) if (print) System.out.println(getDistance(last,scanner));
			//if (last!=null) sumLen+=getDistance(last,scanner);
			if (i<(input.size()-1)) s+=scanner.getName()+"��";
			else s+=scanner.getName();
			i++;
			//last=scanner;
		}

	
		s+=" Sum ��"+VertexArrayLen(input);
		
		return s;
		
	}
	public ArrayList<VertexNode> getResult2()
	{
		VertexNode scanner=end;
		//end.from=start;
		//route.add(start);
		route=new ArrayList<VertexNode>();
		while ((scanner!=null)&&(!route.contains(scanner)))
		{
			route.add(scanner);
			scanner=scanner.from;
		}
		route.add(end);
	     Collections.reverse(route);
	     return route;
	}
	public ArrayList<VertexNode> getResult()
	{
		VertexNode scanner=end;
		//end.from=start;
		//route.add(end);
		route=new ArrayList<VertexNode>();
		while ((scanner!=null)&&(!route.contains(scanner)))
		{
			route.add(scanner);
			scanner=scanner.from;
		}
	     Collections.reverse(route);
	     return route;
	}
	public void Notice(String msg)
	{
		DateFormat df= new SimpleDateFormat("HH:mm:ss.SSS"); 
		label.setText("<html>"+df.format(new Date())+"-"+msg+"<br>"+label.getText());
		System.out.println(df.format(new Date())+"-"+msg);
	}
	public void init() {
		VertexNode head=VertexNode.get(0);
		this.init(head,head);
		
	}

}
