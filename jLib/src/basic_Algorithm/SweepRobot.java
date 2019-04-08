package basic_Algorithm;

public class SweepRobot {
	private int x;
	private int y;
	private SweepMap map;
	private int direction; //1�� 2�� 3�� 4��
	private boolean lastTurn;
	public SweepRobot()
	{
		
	}
	public SweepRobot(SweepMap map, int x, int y)
	{
		this.map=map;
		this.x=x;
		this.y=y;
		lastTurn=false;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int cmdTran(int cmd)
	{
		int dir=-1;
		if (direction==1)
		{
			dir=cmd+1;
		}
		if (direction==2)
		{
			if (cmd==2) dir=4;
			else dir=cmd;
		}
		if (direction==3)
		{
			if (cmd==3) dir=4;
			else dir=cmd;
		}
		if (direction==4)
		{
			dir=cmd;
		}
		return dir;
	}
	public boolean action(int cmd)//CMD 0 123
	{
		//System.out.println("Now cmd:"+cmd);
		if (cmd==0)
		{
			return move();
		}
	
		
		int dir=cmdTran(cmd);
		//System.out.println("Turn dir:"+dir);
		return turn(dir);
	}
	public boolean move()
	{
		//System.out.println("Move DIR->"+direction);
		lastTurn=false;
		if (direction==1) x++;
		if (direction==2) y++;
		if (direction==3) x--;
		if (direction==4) y--;
		//System.out.println("x="+x+" y="+y);
		return (map.Finished(x, y));
		//return true;
	}
	/*
	public void incX()
	{
		x++;
	}
	public void decX()
	{
		x--;
	}
	public void incY()
	{
		y++;
	}
	public void decY()
	{
		y--;
	}
	*/
	public boolean turn(int dir)
	{
		if (dir==-1) return false;
		if (lastTurn) return false;
		lastTurn=true;
		this.direction=dir;
		return true;
		//if (this.direction==direction) return;
	}
	public void initTurn(int direction)
	{
		this.direction=direction;
	}
	public void init()
	{
		this.x=0;
		this.y=0;
		map.Finished(0, 0);
		lastTurn=true;
	}
}
