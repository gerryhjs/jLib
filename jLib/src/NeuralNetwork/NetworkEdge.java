package NeuralNetwork;

//������ߵ�Ȩֵ
public class NetworkEdge {
	private double weight;
	private NetworkNeural from;
	private NetworkNeural to;
	private double ADJUSTINDEX=0.0005;
	public NetworkEdge(NetworkNeural n1, NetworkNeural n2)
	{
		from=n1;
		to=n2;
		weight=Math.random()*0.6+0.1;
		//weight=w;)*0.6+0.1;
		//weight=1;
	}
	public NetworkNeural fromNeural()
	{
		return from;
	}
	public NetworkNeural toNeural()
	{
		return to;
	}
	public double getWeight()
	{
		return weight;
	}
	public void setWeight(double weight)
	{
		this.weight=weight;
	}
	///Math.abs(val)/val
	public void adjust(double dif,double val)
	{
		//if ((val<1) && (val>-1)) return;/Math.abs(val)
		if (val==0) return;
		//if ((val<1) && (val>-1)) return;/Math.abs(val)Math.sqrt(Math.abs(dif))*
		weight+=(Math.abs(dif))*dif/val*ADJUSTINDEX;//*(1+Math.random()*0);
		if (weight>3) weight=3;
		if (weight<-3) weight=-3;
	}
	
}
