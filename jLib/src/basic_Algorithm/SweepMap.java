package basic_Algorithm;

public class SweepMap {
	private int X;
	private int Y;
	private int[][] a;
	public SweepMap(int X,int Y)
	{
		this.X=X;
		this.Y=Y;
		this.a=new int[X][Y];
		init();
	}
	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}
	
	public boolean Finished(int x,int y)
	{
		//if((x>0) ||(y>0)) System.out.println("x="+x+" y="+y);
		if ((x>=0) && (y>=0) && (x<this.X) && (y<this.Y))
		{
			a[x][y]=1;
			//if((x>0) ||(y>0))System.out.println("work");
			//if((x>0) ||(y>0)) PrintMap();
			return true;
		}
		else
			return false;
	}
	public boolean isFinished(int x,int y)
	{
		return (a[x][y]==1);
	}
	public boolean isFinished()
	{
		for (int i=0;i<X;i++)
			for (int j=0;j<Y;j++)
				if (!isFinished(i,j)) 
					{
					//System.out.println(i+"*"+j);
					return false;
					}
		return true;
	}
	public void init() {
		for (int i=0;i<X;i++)
			for (int j=0;j<Y;j++)
				a[i][j]=0;
		
	}
	public void PrintMap()
	{
		for (int i=0;i<X;i++)
		{
			for (int j=0;j<Y;j++)
				System.out.print(a[i][j]);
			System.out.println();
		}	
		//System.out.println();
	}
}
