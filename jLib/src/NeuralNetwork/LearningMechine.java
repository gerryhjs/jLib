package NeuralNetwork;

import picDeal.Picture;

import java.util.ArrayList;

public class LearningMechine {
	private ArrayList<Network> n;
	private ArrayList<Picture> p;
	private int inputNum;
	private int typeNum;
	public LearningMechine(int inputNum,int typeNum)
	{
		n=new ArrayList<Network>();
		p=new ArrayList<Picture>();
		this.inputNum=inputNum;
		this.typeNum=typeNum;
		for (int i=0;i<typeNum;i++)
			n.add(new Network(inputNum));
	}
	public void trainInput(int index,Picture input,int result)
	{
		p.set(index, input);
		double[] data=new double[inputNum+1];
		for (int i=0;i<inputNum;i++)
		{
			if (index==i) data[i]=1;
			else data[i]=-1;
		}
		int t=0;
		for (Network Scanner:n)
		{
			if (t==result) data[inputNum+1]=1;
			else data[inputNum+1]=0;
			Scanner.training(data);
			t++;
		}
	}
	
	public int run(Picture input)
	{
		double[] data=new double[inputNum];
		int t=0;
		double max=-99999;
		int ans=0;
		for (Network Scanner:n)
		{
			for (int i=0;i<inputNum;i++)
			{
				data[i]=compare(input,p.get(i),1);
			}
			Scanner.predict(data);
			double v=Scanner.getOutputs().get(0).getValue();
			if (v>max) 
				{
				max=v;
				ans=t;
				}
			t++;
		}
		return ans;
	}
	public static double compare(Picture pic1,Picture pic2,double t)
    {
    	double x=100;
    	double y=50;
    //	System.out.println(t);
    	double x0=x*t;
    	double y0=y*t;
    	pic1.setPic((int)x0,(int)y0);
    	pic2.setPic((int)x,(int)y);
    	double[][] p1=pic1.getPic();
    	//double[][] p1x=pic1.getPicx();
    	double[][] p2=pic2.getPic();
    	//double[][] p2x=pic2.getPicx();
    	/*
    	int x1=pic1.getX();
    	int y1=pic1.getY();
    	int x2=pic2.getX();
    	int y2=pic2.getY();
    	*/
    	//System.out.print(x1+" "+y1+" "+x2+" "+y2+" ");
    	return max(comparePic(p1,p2,(int)x0,(int)y0,(int)x,(int)y));//,comparePic(p1x,p2,x1,y1,x2,y2),comparePic(p1,p2x,x1,y1,x2,y2),comparePic(p1x,p2x,x1,y1,x2,y2));
    }
    public static double comparePic(double[][] p1,double[][]p2,int x1,int y1,int x2,int y2)
    {
    	
    	double[][] px1=new double[2*x1+x2+1][2*y1+y2+1];
    	double[][] px2=new double[2*x1+x2+1][2*y1+y2+1];
    	for (int i=0;i<2*x1+x2+1;i++)
    		for (int j=0;j<2*y1+y2+1;j++)
    		{
    			px1[i][j]=-10000;
    			px2[i][j]=10000;
    		}
   
    	
    	double maxSimilar=0;
    	for (int x=0;x<x1;x++)
			for (int y=0;y<y1;y++)
				px2[x+x1][y+y1]=p2[x][y];
    	for (int i=0;i<=x1+x2;i++)
    		for (int j=0;j<=y1+y2;j++)
    		{
    			for (int x=0;x<x1;x++)
    				for (int y=0;y<y1;y++)
    					px1[x+i][y+j]=p1[x][y];
    			double sim=0;
    			for (int i1=x1;i1<x1+x2;i1++)
    				for (int j1=y1;j1<y1+y2;j1++)
    				{
    					sim+=compareColor(px1[i1][j1],px2[i1][j1]);
    					maxSimilar=max(maxSimilar,sim);
    				}
    			
    		}
    	double s=maxSimilar/(min(x1*y1, x2*y2));
    	if (s>1) s=1;
    	if (s<0) s=0;
    	return s;
    }
    public static double compareColor(double c1,double c2)
    {
    //	System.out.println(c1);
    //	System.out.println(c2);
   // 	if (Math.abs(c1-c2)==0) return 1;
    	if ((c1==1) && (c2==1)) return 1.6;
     	if ((c1==0) && (c2==0)) return 0.6;
    	//if (Math.abs(c1-c2)<=5) return 0.5;
    	//if (Math.abs(c1-c2)<10) return 0.8;
    	//if (Math.abs(c1-c2)<20) return 0.6;
    	//if (Math.abs(c1-c2)<50) return 0.3;
    	return -0.2;
    }
/*
   
    
  
   
    public static double compare(Picture pic1,Picture pic2)
    {
    	//pic1.setPic();
    	//pic2.setPic();
    	double[][] p1=pic1.getPic();
    	double[][] p2=pic2.getPic();
    	int x1=pic1.getXsize();
    	int y1=pic1.getYsize();
    	int x2=pic2.getXsize();
    	int y2=pic2.getYsize();
    	System.out.println(x1+" "+y1+" "+x2+" "+y2);
    	double[][][][] dif=new double[x1+1][y1+1][x2+1][y2+1];
    	for (int a=0;a<=x1;a++)
    		for(int b=0;b<=y1;b++)
    			dif[a][b][0][0]=(double)Math.max(a, b);
      	for (int a=0;a<=x2;a++)
    		for(int b=0;b<=y2;b++)
    			dif[0][0][a][b]=(double)Math.max(a, b);
    	for (int a=1;a<=x1;a++)
    		for (int b=1;b<=y1;b++)
    			for (int c=1;c<=x2;c++)
    				for (int d=1;d<=y2;d++)
    				{
    					double temp;
    					if (Math.abs(p1[a][b]-p2[c][d])<=0.2)
    					{
    						temp=0;
    					}
    					else
    					{
    						temp=1;
    					}
    						dif[a][b][c][d]=min(dif[a-1][b-1][c-1][d-1]+temp,dif[a][b-1][c][d-1]+1,dif[a-1][b][c-1][d]+1);
    					
    				}
    	  System.out.println(dif[x1][y1][x2][y2]);
    	  double similar =1 - (double) dif[x1][y1][x2][y2] / (double)max(x1,y1,x2,y2); 
	      return similar;
    }
    */
    private static double min(double... is) {  
        double min = 99999;  
        for (double i : is) {  
            if (min > i) {  
                min = i;  
            }  
        }  
        return min;  
    }  
    
    private static double max(double... is) {  
        double min = 0;  
        for (double i : is) {  
            if (min < i) {  
                min = i;  
            }  
        }  
        return min;  
    }  
	
}
