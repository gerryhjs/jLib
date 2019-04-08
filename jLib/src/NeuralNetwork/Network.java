package NeuralNetwork;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Network {
	private ArrayList<NetworkNeural> inputs=new ArrayList<NetworkNeural>();
	private ArrayList<NetworkNeural> mid=new ArrayList<NetworkNeural>();
	private ArrayList<NetworkNeural> outputs=new ArrayList<NetworkNeural>();
	//private ArrayList<Edge> Edges=new ArrayList<Edge>();
	//private Neural output;
	//private int inNum;
	//private int ouNum;
	private int midNum;
	DecimalFormat    df   = new DecimalFormat("######0.000");   
	
	public int getmidNum()
	{
		return midNum;
	}
	public ArrayList<NetworkNeural> getInputs()
	{
		return inputs;
	}
	public ArrayList<NetworkNeural> getMid()
	{
		return mid;
	}
	public ArrayList<NetworkNeural> getOutputs()
	{
		return outputs;
	}
	public Network(int m)//中间神经元的数量
	{
		//inNum=m;
		//ouNum=n;
		int n=1;
		midNum=(int)Math.sqrt(m+n)+3;
		
		for (int i=0;i<m;i++)
		{
		NetworkNeural input=new NetworkNeural();
		inputs.add(input);
		}
		
		for (int i=0;i<n;i++)
		{
		NetworkNeural output=new NetworkNeural();
		outputs.add(output);
		}
		
		//double w=0.1;
		for (int i=0;i<midNum;i++)
		{
			mid.add(new NetworkNeural());
		}
		/*
		for (Neural Scanner:inputs)
		{
			for(Neural Scanner2:outputs)
			{
				Scanner.addRelate(Scanner2);
			
			}
		}
		*/
		for (NetworkNeural Scanner:inputs)
		{
			for(NetworkNeural Scanner2:mid)
			{
				Scanner.addRelate(Scanner2);
			
			}
		}
		for (NetworkNeural Scanner:mid)
		{
			for(NetworkNeural Scanner2:outputs)
			{
				Scanner.addRelate(Scanner2);
		
			}
		}
	}
	public void addInsert()
	{
		insert(new NetworkNeural());
	}
	public void insert(NetworkNeural n)
	{
		inputs.add(n);
	}
	

	public void work()
	{
		//第一层神树元传输
		for (NetworkNeural Scanner:mid)
			Scanner.setValue(0);
		for (NetworkNeural Scanner:outputs)
			Scanner.setValue(0);
		for (NetworkNeural Scanner:inputs)
		{
			Scanner.active();
		}
		//第二层神经元传输
		for (NetworkNeural Scanner:mid)
		{
			Scanner.threshold();
			Scanner.active();
		}
		for (NetworkNeural Scanner:outputs)
		{
		Scanner.threshold();
		}
	}
	

	
	public void training(double[] data)
	{
		int i=0;
		for (NetworkNeural Scanner:inputs)
		{
			Scanner.setValue(data[i]);
			i++;
		}
		work();
		//printMap();
		for (NetworkNeural Scanner:outputs)
		{
			feedBack(Scanner,data[i]);
			i++;
		}
	}
	public double predict(double[] data)
	{
		int i=0;
		for (NetworkNeural Scanner:inputs)
		{
			Scanner.setValue(data[i]);
			i++;
		}
		work();
		System.out.println("Output");
		for (NetworkNeural Scanner:outputs)
		{
			System.out.println(df.format(Scanner.getValue()));
			return Scanner.getValue();
		}
		return -1;
	}
	public void printMap()
	{
		System.out.println("Input");
		for (NetworkNeural Scanner:inputs)
		{
			System.out.println(df.format(Scanner.getValue()));
		}
		System.out.println("Mid");
		for (NetworkNeural Scanner:mid)
		{
			System.out.println(df.format(Scanner.getValue()));
		}
		System.out.println("Output");
		for (NetworkNeural Scanner:outputs)
		{
			System.out.println(df.format(Scanner.getValue()));
		}
	}
	/*
	public void printEdges()
	{
		System.out.println("I-M----------------------EdgeWeights");
		for (Neural Scanner:inputs)
		{
			for (Neural Scanner2:mid)
			System.out.println(df.format(Scanner.getToEdge(Scanner2).getWeight()));
		}
		System.out.println("M-O----------------------EdgeWeights");
		for (Neural Scanner:mid)
		{
			for (Neural Scanner2:outputs)
			System.out.println(df.format(Scanner.getToEdge(Scanner2).getWeight()));
		}
	}
	*/
	/*
	public void printRelate()
	{
		System.out.println("Input-Mid");
		
	}
	*/
	public void feedBack(NetworkNeural output, double fact)
	{

		double dif=fact-output.getValue();

		//else dif=dif*0.8;
		System.out.println(df.format(fact)+"/"+df.format(output.getValue()));
		//System.out.println("Dif:"+df.format(dif));
		//if (fact*output.getValue()<0) dif*=2;
		for (NetworkNeural Scanner2:outputs)
		{
		Scanner2.adjust(dif);
		}
		
	}
	
}