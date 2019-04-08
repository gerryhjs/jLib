package basic_Algorithm;

import java.util.ArrayList;

//import java.util.ArrayList;

public class VertexNode {
	private String name;
	public int min;
	public boolean been;
	public VertexNode from;
	public ArrayList<VertexNode> to=new ArrayList<VertexNode>();
	//public ArrayList<VertexNode> go;
	public VertexNode()
	{
		
	}
	public VertexNode(String name)
	{
		setName(name);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
