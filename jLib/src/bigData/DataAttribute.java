package bigData;

import java.util.ArrayList;


public class DataAttribute {
	private String name;
	private ArrayList<DataValue> values;
	private BigDataSystem base;
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
