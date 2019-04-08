package bigData;

import java.util.ArrayList;

public class DataObject {
	private String name;
	private ArrayList<DataValue> values;

	private BigDataSystem base;
	public DataObject(String name, BigDataSystem base)
	{
		this.name=name;
		values=new ArrayList<DataValue>();
		this.base=base;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	public double getValue(String attributeName)
	{
		for (DataValue Scanner:values)
		{
			try {
				if (Scanner.getAttribute().getName().equals(attributeName)) return Scanner.getValue();
			}
			catch (Exception e)
			{

			}
		}
		return base.DEFAULT_NULL;
	}
	public void setValue(String attributeName,double value)
	{
		System.out.println("Set"+value);
	
		
		for (DataValue Scanner:values)
		{
			if (Scanner.getObject().getName().equals(attributeName)) 
				{
				Scanner.setValue(value);
				return;
				}
		}
	//	System.out.println(base.getAttriute(attributeName).getName());
		values.add(new DataValue(this,base.getAttriute(attributeName),value));
		
	}
	
	public DataObject copy()
	{
		DataObject copy=new DataObject(name,base);
		for (DataValue Scanner:values)
		{
			copy.setValue(Scanner.getObject().getName(),Scanner.getValue());
		}
		return copy;
	}

	
}
