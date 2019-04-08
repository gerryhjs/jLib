package bigData;

import ChartINF.SpiralChart;
import ChartINF.SpiralPoint;
import NeuralNetwork.Network;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class BigDataSystem {
	private ArrayList<DataObject> Objects;
	private ArrayList<DataAttribute> Attributes;
	private ArrayList<DataObject> ObjectsDraft;
	//private ArrayList<DataAttribute> AttributesDraft;
	public double DEFAULT_NULL = 0;
	public BigDataSystem()
	{
		init();
		//DataObject o=new DataObject("A",this);
		
	}
	public void createChart() throws IOException {
		ArrayList<SpiralPoint> p=new ArrayList<SpiralPoint>();
		for (DataObject Scanner1:Objects)
		{
			String object=Scanner1.getName();
			for (DataAttribute Scanner2:Attributes)
			{
				String attribute=Scanner2.getName();
				double value=Scanner1.getValue(Scanner2.getName());
				System.out.println(value);
				p.add(new SpiralPoint(object,attribute,value));
			}
		}
		SpiralChart sc=new SpiralChart("我是标题",p);
	}
	/*
	public void createChart(ArrayList<DataObject> selectedObjects) throws IOException
	{
		ArrayList<SpiralPoint> p=new ArrayList<SpiralPoint>();
		for (DataObject Scanner1:selectedObjects)
		{
			String object=Scanner1.getName();
			for (DataAttribute Scanner2:Attributes)
			{
				String attribute=Scanner2.getName();
				double value=Scanner1.getValue(Scanner2.getName());
				p.add(new SpiralPoint(object,attribute,value));
			}
		}
		@SuppressWarnings("unused")
		SpiralChart sc=new SpiralChart(p);
	}
	*/
	public void createChart(DataObject... selectedObjects) throws IOException {
		ArrayList<SpiralPoint> p=new ArrayList<SpiralPoint>();
		for (DataObject Scanner1:selectedObjects)
		{
			String object=Scanner1.getName();
			for (DataAttribute Scanner2:Attributes)
			{
				String attribute=Scanner2.getName();
				double value=Scanner1.getValue(Scanner2.getName());
				p.add(new SpiralPoint(object,attribute,value));
			}
		}
		SpiralChart sc=new SpiralChart("Result",p);
	}
	public void addObject(DataObject o)
	{
		Objects.add(o);
	}
	public void addAttribute(DataAttribute a)
	{
		Attributes.add(a);
	}
	public void removeObject(DataObject o)
	{
		Objects.remove(o);
	}
	public void removeAttribute(DataAttribute a)
	{
		Attributes.remove(a);
	}
	public DataObject getObject(String name)
	{
		for (DataObject Scanner:Objects)
		{
			if (Scanner.getName().equals(name)) return Scanner;
		}
		return null;
	}
	public DataAttribute getAttriute(String name)
	{
		for (DataAttribute Scanner:Attributes)
		{
			if (Scanner.getName().equals(name)) return Scanner;
		}
		return null;
	}
	public void init()
	{
		this.Objects=new ArrayList<DataObject>();
		this.Attributes=new ArrayList<DataAttribute>();
	}
	
	public void saveDraft()
	{
		ObjectsDraft=new ArrayList<DataObject>();
		for (DataObject Scanner:Objects)
		{
			DataObject o=Scanner.copy();
			ObjectsDraft.add(o);
		}
	}
	
	public void loadDraft()
	{
		Objects=ObjectsDraft;
	}
	
	public double getRelate(String a1,String a2,ArrayList<DataObject> target)
    {
    	double sum=0;
    	double i=0;
    	for (DataObject Scanner:target)
    	{
    			double d1=Scanner.getValue(a1);
    			double d2=Scanner.getValue(a2);

			if ((d1!= DEFAULT_NULL) && (d2!= DEFAULT_NULL))
    			{
    				i++;
    			double dif=Math.abs(d2-d1)*(d2-d1);
    			//if (d1*d2<0) dif*=1.5;
    			sum+=dif;
    			}
    	}

    	System.out.println("sum="+sum);
    	System.out.println("i="+i);
    	if (i==0) return 0;
    	if (sum==0) return 0;
    	double relatedIndex=Math.sqrt(Math.abs(sum/i))*Math.abs(sum/i)/(sum/i);
    	//if (relatedIndex>=2) relatedIndex=2;
    	//if (relatedIndex<=0) relatedIndex=0;
     	return relatedIndex;
    }
	public DataAttribute runSuggest(DataObject object,ArrayList<DataAttribute> known,ArrayList<DataAttribute> unkown)
	{
		double maxAns=-1;
    	DataAttribute result=null;
    	for (DataAttribute Scanner1:unkown)
    	{
    		double ans=0;
    		for(DataAttribute Scanner2:known) {
				System.out.println("--");
				try {
					double relateIndex = getRelate(Scanner2.getName(), Scanner1.getName(), Objects);
					double d = object.getValue(Scanner2.getName());
					ans += d * relateIndex;
					System.out.println(Scanner1.getName() + " " + Scanner2.getName());
					System.out.println("Value=" + d);
					System.out.println("RI=" + relateIndex);
					System.out.println("result=" + ans);

				//	if (ans < -2) ans = -2;
				//	if (ans > 2) ans = 2;
					System.out.println("ans=" + ans);
					object.setValue(Scanner1.getName(), ans);
					if (ans > maxAns) {
						result = Scanner1;
						maxAns = ans;
					}
				}
				catch(Exception e)
				{

				}
			}

    	}
    	return result;
	}
	
	public void printRelate()
	{
		DecimalFormat    df   = new DecimalFormat("######0.00");
		for (DataAttribute Scanner1:Attributes)
			for (DataAttribute Scanner2:Attributes)
			{
				System.out.println(Scanner1.getName()+"-"+Scanner2.getName()+":"+df.format(getRelate(Scanner1.getName(),Scanner2.getName(),Objects)));
			}
	}

//use neural network to predict
	public DataAttribute runSuggest2(DataObject x2, ArrayList<DataAttribute> known, ArrayList<DataAttribute> unknown) {
		int size=known.size()+unknown.size();
		Network nn=new Network(known.size(),unknown.size(),0.00000005);
		for (int t=0;t<=10000;t++) {
			for (DataObject o : Objects) {
				double[] inputDatas = new double[size];
				int index = 0;
				for (DataAttribute da : known) {
					inputDatas[index] = (o.getValue(da.getName()));
					index++;
				}
				for (DataAttribute da : unknown) {
					inputDatas[index] = (o.getValue(da.getName()));
					index++;
				}
				nn.training(inputDatas);
			}
		}
		double[] inputDatas=new double[known.size()];
		int index=0;
		for (DataAttribute da:known) {
			inputDatas[index] = (x2.getValue(da.getName()));
			index++;
		}
		double[] result=nn.predict(inputDatas);
		System.out.println("Rss="+result);
		double max=-99999;
		DataAttribute target=null;
		for (int i=0;i<unknown.size();i++)
		{
			if (result[i]>max)
			{
				max=result[i];
				target=unknown.get(i);
			}
		}
		return target;
	}
}
