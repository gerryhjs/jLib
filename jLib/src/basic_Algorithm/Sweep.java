package basic_Algorithm;

public class Sweep {
	
	static SweepMap map;
	static SweepRobot robot;
	static double t=0;
	static double tSperM;
	static double tTurn;
	static int maxStep=10;
	static long maxTemp=(long) Math.pow(4,(double)maxStep);
	public static void main(String[] args){
		int Y=2;
		int X=2*Y;
		tSperM=(double)(3)/(double)(Y);
		tTurn=(double)0.25;
		////System.out.println(SperM);
		map=new SweepMap(X,Y);

		robot=new SweepRobot(map,0,0);
		double minT=(double)99999;
		int minX=99999;
		int AnsDir=-1;
		int[] Solution = null;
		for (int dir=1;dir<=1;dir++)
		{
			//System.out.println("Dir="+dir);

			//ArrayList<int[]> list=getCMDList();
			int[] tempList = new int[maxStep];
			int[] lastList = new int[maxStep];
			for (int i=0;i<maxStep;i++)
				tempList[i]=0;
			//lastList=tempList;
			//testInit(tempList);
			for (long j=0;j<maxTemp;j++)
			{
				//System.out.print("Dir"+dir+":");
				//new ProcessBuilder("cmd", "/C", "cls").inheritIO().start();
				
				
				System.out.print(Math.round(((double)j/(double)maxTemp)*100) +"%:");
				for (int x=0;x<maxStep;x++)
					{
					 System.out.print(tempList[x]);
					}
				System.out.println();
				
				
				map.init();
				t=0;
				robot.init();
				robot.initTurn(dir);
				int index=0;
				for (int i=0;i<maxStep;i++)
				{
		
					if (map.isFinished())
					{
						//System.out.println("Successed!");
				
						break;
					}
					if (!RobotControl(tempList[i])) 
					{	
						//System.out.println("Error!");

						break;
					}
					index++;
				}
			
				//map.PrintMap();
				if (map.isFinished())
				{
					//System.out.println("SumT="+t);
					if (t<minT) 
					{
						minX=index;
						Solution=tempList;
						minT=t;
						AnsDir=dir;
					}
				}
				tempList=new int[maxStep]; 
				boolean flag=true;
				for (int i=0;i<maxStep;i++)
				{
					if (flag)
					{
						if (lastList[i]<3) 
						{
							tempList[i]=lastList[i]+1;
							flag=false;
						}
						else
						{
							tempList[i]=0;	
						}
					}
					else
					{
						tempList[i]=lastList[i];
					}
					
				}
				lastList=tempList;
			}
			/*
			//while(!map.isFinished())
			{
				for (int i=0;i<=3;i++)
					robot.action(i);
			}*/	
		}
		//System.out.println("Direction:"+AnsDir);
		System.out.println(maxTemp);
		//System.out.print("Solution:");
		int dir=AnsDir;
		System.out.print("StartDirection:");
		if (dir==1) System.out.print("��");
		if (dir==2) System.out.print("��");
		if (dir==3) System.out.print("��");
		if (dir==4) System.out.print("��");
		System.out.println();
		for (int x=0;x<minX;x++)
		{
			//System.out.print(Solution[x]);
			int cmd=Solution[x];
			if (cmd==0) System.out.print("M");
			else
				{
				dir=cmdTran(cmd,dir);
				if (dir==1) System.out.print("��");
				if (dir==2) System.out.print("��");
				if (dir==3) System.out.print("��");
				if (dir==4) System.out.print("��");
				}
			
		}
		System.out.println();
		System.out.println("ShortestT="+minT);
	}
	public static int cmdTran(int cmd,int direction)
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
	@SuppressWarnings("unused")
	private static void testInit(int[] a) {
		a[0]=0;
		a[1]=1;
		a[2]=0;
		a[3]=3;
		a[4]=0;
		
	}
	public static boolean RobotControl(int cmd)
	{
		//System.out.println("cmd="+cmd);
		if (map.isFinished()) 
			{
			//System.out.println("Finish! T="+t);
			return false;
			}
		if (cmd==0) t+=tSperM;
		else t+=tTurn;
		if (!robot.action(cmd))
			{
			//System.out.println("Error Action!");
			return false;
			}
		return true;
	}
	/*
	public static ArrayList<int[]> getCMDList()
	{
		ArrayList<int[]> list=new ArrayList<int[]>();
		int[] tempList = new int[maxStep];
		int[] lastList = new int[maxStep];
		for (int i=0;i<maxStep;i++)
			tempList[i]=0;
		list.add(tempList);
		lastList=tempList;
		for (long j=1;j<(long)Math.pow((double)4, (double)maxStep);j++)
		{
			tempList=new int[maxStep]; 
			boolean flag=true;
			for (int i=0;i<maxStep;i++)
			{
				if ((lastList[i]<4) && (flag))
				{
				tempList[i]=lastList[i]+1;
				flag=false;
				}
				else
				{
				tempList[i]=0;	
				}
			}
			list.add(tempList);
			lastList=tempList;
		}
		return list;
	}*/
	/*
	   static public double log(double value, double base) {
		   return Math.log(value) / Math.log(base);
		   }
		   */
	/*
	 * 
	public static boolean RobotControl(int cmd)
	{
		//System.out.println("cmd="+cmd);
		if (map.isFinished()) 
			{
			//System.out.println("Finish! T="+t);
			return false;
			}
		if (cmd==0) t+=tSperM;
		else t+=tTurn;
		if (!robot.action(cmd))
			{
			//System.out.println("Error Action!");
			return false;
			}
		//for (int i=0;i<=0;i++)
			//RobotControl(i);
		return true;
	}*/
}
