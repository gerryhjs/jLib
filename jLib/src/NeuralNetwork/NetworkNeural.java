package NeuralNetwork;

import java.util.ArrayList;

//神经网络中的神经元
public class NetworkNeural {
	
	private ArrayList<NetworkNeural> next=new ArrayList<NetworkNeural>();//往后的神经元
	private ArrayList<NetworkNeural> head=new ArrayList<NetworkNeural>();//往前的神经元
	private ArrayList<NetworkEdge> tran=new ArrayList<NetworkEdge>();//权重边
	private double value;
	private double threshold;
	public NetworkNeural()
	{
		value=0;
		threshold=0;
	}
	public NetworkNeural(double t)
	{
		value=0;
		threshold=t;
	}
	
	public void threshold()
	{
		value-=threshold;
		//if (value<0) value=0;
	}
	public void setValue(double v)
	{
		value=v;
	}
	
	public void addValue(double input)
	{
		value+=input;
	}
	
	public double getValue()
	{
		return value;
	}
	public void addHead(NetworkNeural n)
	{
		head.add(n);
	}		
	public void addRelate(NetworkNeural n)
	{
		NetworkEdge e=new NetworkEdge(this,n);
		next.add(n);
		n.addHead(this);
		tran.add(e);
	}
	public void active()
	{
		//if (value>0)
		{
			for(NetworkNeural Scanner:next)
			{
				try
				{
				Scanner.addValue(getValue()*getToEdge(Scanner).getWeight());
				}
				catch (Exception e)
				{
					System.out.println("Active Error:"+e);
				}
			}
		}
	}
	public void adjust(double dif)
	{
		for(NetworkNeural Scanner:head)
		{
			for (NetworkEdge Scanner2:Scanner.tran)
			{
				if (Scanner2.toNeural()==this)
				Scanner2.adjust(dif, Scanner.getValue());
			}
			Scanner.adjust(dif/Scanner.getToEdge(this).getWeight());///Math.abs(value));
		}
	}
	
	/*
	public void calcMyValue()
	{
		//double v=0;
		value=0;
		for (Neural Scanner:head)
		{
			try
			{
			value+=Scanner.getValue()*getFromEdge(Scanner).getWeight();
			}
			catch (Exception e)
			{
				
			}
		}
	}
	*/
	/*
	public void checkValue(double value)
	{
		
	}
	*/
	
	public NetworkEdge getFromEdge(NetworkNeural last)
	{
		for (NetworkEdge Scanner:tran)
		{
			if ((Scanner.toNeural()==this)&&(Scanner.fromNeural()==last))
				return Scanner;
		}
		return null;
	}
	
	public NetworkEdge getToEdge(NetworkNeural next)
	{
		for (NetworkEdge Scanner:tran)
		{
			if ((Scanner.fromNeural()==this)&&(Scanner.toNeural()==next))
				return Scanner;
		}
		return null;
	}
}
