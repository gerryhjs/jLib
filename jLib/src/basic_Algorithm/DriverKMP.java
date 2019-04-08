package basic_Algorithm;

public class DriverKMP {
	public static void main(String[] args) {
	      // System.out.println(kmp.search("ABABACBABCABABABCAABABACABBCBABCABABCABCCABABABACC"));
	      // String txt="54321ABABACAB12345";
		  int scanLen=3;
		  String key = "ABABC";//0 0 1 1 2
		    KMP kmp = new KMP(key);
		  String txt="ABABCABABABACBABCABABABAABCABCAABABAAABABCAAABAABCABAABCAACABACABABAABAABAABCABCBCAAABAABCBABAAACABBAABAABCCABBAACBABCABAABABCBAABABACBABCABABABCAABABACABBCBABCABAABACCBABABC";
		    String ctxt="----*"+txt+"*----";
		  int i=0;
		  int x=5;
		  while(true)
		  {
		    int len=key.length();
	        int index=kmp.search(txt); 
	        try
	        {
	        // txt=txt.substring(index+len,txt.length());	
	        //System.out.println(txt); 
	        //System.out.println(index); 
		    x+=index;
	        String a=ctxt.substring(x-scanLen, x);
	        String f=ctxt.substring(x, x+len);
	        String b=ctxt.substring(x+len, x+len+scanLen);
	        i++;
	        System.out.println("Result"+i+":.."+a+"["+f+"]"+b+"..");
	        txt=txt.substring(index+1,txt.length());
	        x++;
	        //txt=txt.substring(1,txt.length());
	        }
	        catch (Exception e)
	        {
	        	System.out.println("Finish");
	            //txt=txt.substring(1,txt.length());
	        	return;
	        }
		}
	}
}
