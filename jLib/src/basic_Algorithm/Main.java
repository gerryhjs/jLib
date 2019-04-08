package basic_Algorithm;

import java.util.Scanner;

public class Main {
	     private static String key;
	     private static String txt;
	     private static int[][] dfa;
	     
	     public static String getString()
	     {
	    	 String s="";
	    	 for(int i=1;i<=10000;i++)
	    	 {
	    		 s+=String.valueOf(i);
	    	 }
	    	 //System.out.print(s);
	    	 return s;
	     }
	    public  static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	key=sc.nextLine();  
	    	String s=key;
	    	txt=getString();
	        int M = key.length();
	        int R = 256;
	        dfa = new int[M][R];
	        dfa[0][s.charAt(0)] = 1;
	        for(int X=0,j=1;j<M;j++){
	          // String x=key;
	           //System.out.println(x.substring(j-1, j)+":"+X);
	            for(int c=0;c<R;c++)
	                dfa[j][c] = dfa[X][c];
	            dfa[j][s.charAt(j)] = j+1;
	            X = dfa[X][s.charAt(j)];
	        }   
	        //System.out.println(s);;
	        int ans=search(txt);
	        System.out.println(ans+1);
	        sc.close();
	        
	    }
	    public static int search(String txt){
	        //if (txt.length()==0) return 1;
	        int i,j=0;
	        int N = txt.length();
	        int M=key.length();
	        for(i=0;i<N&&j<M;i++)
	            j = dfa[j][txt.charAt(i)];
	        if(j == M)
	            return i-M;
	        else
	            return N;

	    }
}
/*
	public static void main(String[] args) {
		int a;
		int b;
		int c;
		for (a=100;a<=333;a++)
		{
			b=a*2;
			c=a*3;
			if(pd(a,b,c))
		    {
				print(a,b,c);
			}
		}
	}
	private static void print(int a,int b,int c) {
		System.out.println(a+" "+b+" "+c);		
	}
	public static boolean pd(int a,int b,int c)
	{
		String s1=String.valueOf(a);
		String s2=String.valueOf(b);
		String s3=String.valueOf(c);
		String s=s1+s2+s3;
		for (int i=1;i<=9;i++)
			if (!s.contains(String.valueOf(i))) return false;
		return true;
	}
}
*/