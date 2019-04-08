package basic_Algorithm;
public class KMP {
	  private String key;
	    private int[][] dfa;
	    public  KMP(String s){
	        this.key=s;
	        int M = s.length();
	        int R = 256;
	        dfa = new int[M][R];
	        dfa[0][s.charAt(0)] = 1;
	        for(int X=0,j=1;j<M;j++){
	           String x=s;
	           System.out.println(x.substring(j-1, j)+":"+X);
	            for(int c=0;c<R;c++)
	                dfa[j][c] = dfa[X][c];
	            dfa[j][s.charAt(j)] = j+1;
	            X = dfa[X][s.charAt(j)];
	        }   
	    }
	    public int search(String txt){
	        if (txt.length()==0) return 1;
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
