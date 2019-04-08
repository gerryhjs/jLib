package bigData;

public class DataValue {
	private DataObject object;
	private DataAttribute attribute;
	private double value;
	public DataValue(DataObject object, DataAttribute attribute, double value)
	{
		this.object=object;
		this.attribute=attribute;
		this.value=value;
	}
	public DataAttribute getAttribute() {
		return attribute;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public DataObject getObject() {
		return object;
	}

}
