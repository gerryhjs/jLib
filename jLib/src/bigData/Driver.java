package bigData;

import java.io.IOException;
import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) throws IOException
	{
		test1();
	}

	public static void test1() throws IOException //traditional
	{
		BigDataSystem bds=new BigDataSystem();
		DataObject o1=new DataObject("O1",bds);
		DataObject o2= new DataObject("O2",bds);
		DataObject o3=new DataObject("O3",bds);
		DataObject x1=new DataObject("X1",bds);
		DataObject x2=new DataObject("X2",bds);

		DataAttribute a1=new DataAttribute("商品A",bds);
		DataAttribute a2=new DataAttribute("商品B",bds);
		DataAttribute a3=new DataAttribute("商品C",bds);
		DataAttribute a4=new DataAttribute("商品D",bds);
		DataAttribute a5=new DataAttribute("商品E",bds);
		DataAttribute a6=new DataAttribute("商品F",bds);
		bds.addObject(o1);
		bds.addObject(o2);
		bds.addObject(o3);
		bds.addAttribute(a1);
		bds.addAttribute(a2);
		bds.addAttribute(a3);
		bds.addAttribute(a4);
		bds.addAttribute(a5);
		bds.addAttribute(a6);
		o1.setValue("商品A", 2);
		o1.setValue("商品B", 1);
		o1.setValue("商品C", -2);
		o1.setValue("商品D", -1);
		o1.setValue("商品E", 1);
		o1.setValue("商品F", 2);

		o2.setValue("商品A", -1);
		o2.setValue("商品B", 2);
		o2.setValue("商品C", -2);
		o2.setValue("商品D", -1);
		o2.setValue("商品E", 2);
		o2.setValue("商品F", 2);
		o3.setValue("商品A", -2);

		o3.setValue("商品B", -2);
		o3.setValue("商品C", 2);
		o3.setValue("商品D", 1);
		o3.setValue("商品E", 0);
		o3.setValue("商品F", -2);

		bds.createChart();

		x1.setValue("商品B",2);
		x1.setValue("商品D",1);
		
		ArrayList<DataAttribute> known=new ArrayList<DataAttribute>();
		ArrayList<DataAttribute> unknown=new ArrayList<DataAttribute>();
		known.add(bds.getAttriute("商品B"));
		known.add(bds.getAttriute("商品D"));

		unknown.add(bds.getAttriute("商品A"));
		unknown.add(bds.getAttriute("商品C"));
		unknown.add(bds.getAttriute("商品E"));
		unknown.add(bds.getAttriute("商品F"));
		

		DataAttribute ans1=	bds.runSuggest(x1, known, unknown);
	//	DataAttribute ans1=	bds.runSuggest2(x1, known, unknown);

		
		
		x2.setValue("商品A",-2);
		x2.setValue("商品B",2);
		x2.setValue("商品F",1);
		
		known=new ArrayList<DataAttribute>();
		unknown=new ArrayList<DataAttribute>();
		known.add(bds.getAttriute("商品A"));
		known.add(bds.getAttriute("商品B"));
		known.add(bds.getAttriute("商品F"));
		unknown.add(bds.getAttriute("商品D"));
		unknown.add(bds.getAttriute("商品C"));
		unknown.add(bds.getAttriute("商品E"));

		DataAttribute ans2=bds.runSuggest(x2, known, unknown);
//		DataAttribute ans2=	bds.runSuggest2(x2, known, unknown);

		bds.addObject(x1);
		bds.addObject(x2);
		
		bds.createChart(x1);
		bds.createChart(x2);
		
		//bds.printRelate();


		System.out.println("x1对应的推荐值:"+ans1.getName());
		System.out.println("x2对应的推荐值:"+ans2.getName());

		//bds.createChart(o1,o2,o3);
		//bds.createChart(x1,x2);
		//.createChart(o1);
		//bds.createChart(o2);
		//bds.createChart(o3);
	}



}
