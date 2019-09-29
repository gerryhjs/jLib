package bigData;

import java.util.ArrayList;

//聚类算法中的用户属性
public class DataAttribute {
	private String name;//属性名
	private ArrayList<DataValue> values;//属性的值列表
	private BigDataSystem base;//对应的bds系统
	public DataAttribute(String name, BigDataSystem base)
	{
		this.name = name;
		this.base=base;
		values=new ArrayList<DataValue>();
	}
	public String getName() {
		return name;
	}
	public double getValue(String objectName)
	{
		for (DataValue Scanner:values)
		{
			if (Scanner.getObject().getName().equals(objectName)) return Scanner.getValue();
		}
		return base.DEFAULT_NULL;
	}
	

}
