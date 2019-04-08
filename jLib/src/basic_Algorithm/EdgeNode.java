package basic_Algorithm;

public class EdgeNode {
	//private String name;
	private int weight;
	private String from;
	private String to;
	private boolean direct;
	public int beginIndex;
	public int endIndex;
	public EdgeNode()
	{
		this.direct=false;
	}
	public EdgeNode(String from,String to,int weight)
	{
		this.setFrom(from);
		this.setTo(to);
		this.setWeight(weight);
	}
	public void setDirect()
	{
		this.direct=true;
	}
	public boolean isDirect()
	{
		return direct;
	}
	/*
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	public int getWeight() {
		return weight;
	}
	public void setWeight(int value) {
		this.weight = value;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDetail()
	{
		if (isDirect()) return from+"??"+to+":"+weight;
		return from+"?P"+to+":"+weight;
	}
}
