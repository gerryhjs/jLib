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

		DataAttribute a1=new DataAttribute("��ƷA",bds);
		DataAttribute a2=new DataAttribute("��ƷB",bds);
		DataAttribute a3=new DataAttribute("��ƷC",bds);
		DataAttribute a4=new DataAttribute("��ƷD",bds);
		DataAttribute a5=new DataAttribute("��ƷE",bds);
		DataAttribute a6=new DataAttribute("��ƷF",bds);
		bds.addObject(o1);
		bds.addObject(o2);
		bds.addObject(o3);
		bds.addAttribute(a1);
		bds.addAttribute(a2);
		bds.addAttribute(a3);
		bds.addAttribute(a4);
		bds.addAttribute(a5);
		bds.addAttribute(a6);
		o1.setValue("��ƷA", 2);
		o1.setValue("��ƷB", 1);
		o1.setValue("��ƷC", -2);
		o1.setValue("��ƷD", -1);
		o1.setValue("��ƷE", 1);
		o1.setValue("��ƷF", 2);

		o2.setValue("��ƷA", -1);
		o2.setValue("��ƷB", 2);
		o2.setValue("��ƷC", -2);
		o2.setValue("��ƷD", -1);
		o2.setValue("��ƷE", 2);
		o2.setValue("��ƷF", 2);
		o3.setValue("��ƷA", -2);

		o3.setValue("��ƷB", -2);
		o3.setValue("��ƷC", 2);
		o3.setValue("��ƷD", 1);
		o3.setValue("��ƷE", 0);
		o3.setValue("��ƷF", -2);

		bds.createChart();

		x1.setValue("��ƷB",2);
		x1.setValue("��ƷD",1);
		
		ArrayList<DataAttribute> known=new ArrayList<DataAttribute>();
		ArrayList<DataAttribute> unknown=new ArrayList<DataAttribute>();
		known.add(bds.getAttriute("��ƷB"));
		known.add(bds.getAttriute("��ƷD"));

		unknown.add(bds.getAttriute("��ƷA"));
		unknown.add(bds.getAttriute("��ƷC"));
		unknown.add(bds.getAttriute("��ƷE"));
		unknown.add(bds.getAttriute("��ƷF"));
		

		DataAttribute ans1=	bds.runSuggest(x1, known, unknown);
	//	DataAttribute ans1=	bds.runSuggest2(x1, known, unknown);

		
		
		x2.setValue("��ƷA",-2);
		x2.setValue("��ƷB",2);
		x2.setValue("��ƷF",1);
		
		known=new ArrayList<DataAttribute>();
		unknown=new ArrayList<DataAttribute>();
		known.add(bds.getAttriute("��ƷA"));
		known.add(bds.getAttriute("��ƷB"));
		known.add(bds.getAttriute("��ƷF"));
		unknown.add(bds.getAttriute("��ƷD"));
		unknown.add(bds.getAttriute("��ƷC"));
		unknown.add(bds.getAttriute("��ƷE"));

		DataAttribute ans2=bds.runSuggest(x2, known, unknown);
//		DataAttribute ans2=	bds.runSuggest2(x2, known, unknown);

		bds.addObject(x1);
		bds.addObject(x2);
		
		bds.createChart(x1);
		bds.createChart(x2);
		
		//bds.printRelate();


		System.out.println("x1��Ӧ���Ƽ�ֵ:"+ans1.getName());
		System.out.println("x2��Ӧ���Ƽ�ֵ:"+ans2.getName());

		//bds.createChart(o1,o2,o3);
		//bds.createChart(x1,x2);
		//.createChart(o1);
		//bds.createChart(o2);
		//bds.createChart(o3);
	}



}
