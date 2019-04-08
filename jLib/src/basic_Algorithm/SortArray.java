package basic_Algorithm;

import java.awt.*;

public class SortArray {
	private int[] a;
	private int[] copy;
	public List list;
	//private int[] t=new int[100000];
	//private int[] m1=new int[100000];
	//private int[] m2=new int[100000];

	public SortArray(int[] a)
	{
		this.a=a;
		copy=new int[a.length];
		for (int i=0;i<a.length;i++)
		{
			copy[i]=a[i];
		}
	}
	public void recover()
	{
		this.a=copy;
		/*	
		list.removeAll();
		for (int i=0;i<a.length;i++)
		{
			if (i<=100) list.add(String.valueOf(a[i]));
			if (i==100) list.add("...");
		}
		*/
	}
	/*
	public SortArray(int[] m1,int[] m2)
	{
		this.m1=m1;
		this.m2=m2;
	}
	*/
	public int[] getResult()
	{
		list.removeAll();
		for (int i=0;i<a.length;i++)
		{
			if (i<=100) list.add(String.valueOf(a[i]));
			if (i==100) list.add("...");
		}
		return a;
		
		//int[] temp=a;
		//recover();
		//return temp;
		
	}
	public void quickSort() {
		qsort(0,a.length-1);
	}
	public void qsort(int l,int r)
	{
		if(l>=r) return;
		int index=find(l,r);
		qsort(l,index-1);
		qsort(index,r);
		return;
	}
	public int find(int l,int r){  
        int key = a[r];  
        int i = l -1;  
        for (int j = l; j <= r-1; j++) {  
            if(a[j] <= key){  
                i++;  
                if(i != j){  
                	int temp=a[i];
                	a[i]=a[j];
                	a[j]=temp;
                }  
            }  
        }  
        if((i+1) != r){  
        	int temp=a[r];
        	a[r]=a[i+1];
        	a[i+1]=temp;
        }  
        return i+1;  
    }  
	public void mergeSort() {
		a=sort(0,a.length-1);
	}
	/*
	 if(l+1==r)
		{
			return(mSort(mSort(a[l]),mSort(a[r])));
		} 
			public int[] mSort(int m1,int m2)
	{
		if (m1>=m2)
		{
		int t[]=new int[2];
		t[0]=m2;
		t[1]=m1;
		return t;
		}
		else
		{
		int t[]=new int[2];
		t[0]=m1;
		t[1]=m2;
		return t;
		}
	}
	 */
	public int[] sort(int l,int r)
	{
		if(l==r)
		{
			return(mSort(a[r]));
		}
	    int m=(l+r)/2;
		return mSort(sort(l,m),sort(m+1,r));
	}
	public int[] mSort(int m1)
	{
		int t[]=new int[1];
		t[0]=m1;
		return t;
	}
	public int[] mSort(int[] m1,int[] m2)//,int l1,int l2)
	{
		int i=0;
		int j=0;
		int l1=m1.length;
		int l2=m2.length;
		int[] a=new int[l1+l2];
	//	System.out.println("l1="+l1+" l2="+l2);
		for (int k=0;k<l1+l2;k++)
		{
			if (m1[i]<=m2[j])
			{
				a[k]=m1[i];
				i++; 
			}
			else
			{
				a[k]=m2[j];
				j++; 
			}
			if (i>=l1)
			{
				for (int k2=k+1;k2<l1+l2;k2++)
				{
					a[k2]=m2[j];
					j++;
				}
				/*
				for (i=0;i<l1+l2;i++)
					System.out.print(a[i]+" ");
				System.out.println();
				*/
				return a;
			}
			if (j>=l2)
			{
				for (int k2=k+1;k2<l1+l2;k2++)
				{
					a[k2]=m1[i];
					i++;
				}
				/*
				for (i=0;i<l1+l2;i++)
					System.out.print(a[i]+" ");
				System.out.println();
				*/
				return a;
			}
			
		}

		return a;
	}

	public void bubbleSort()
	{	
		int len=a.length;
		for (int i=0;i<len-1;i++)
			for(int j=0;j<len-i-1;j++)
			{
				if (a[j]>a[j+1]) //swap(a[j],a[j+1]);
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
	}
	public void bubbleSort2() //improve version
	{	
		int len=a.length;
		for (int i=0;i<len-1;i++)
		{
			boolean flag=true;
			for(int j=0;j<len-i-1;j++)
			{
				if (a[j]>a[j+1]) //swap(a[j],a[j+1]);
				{
					flag=false;
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			if (flag) return;
		}
	}
	public void insertSort()
	{
		int len=a.length;
		for (int i=0;i<len;i++)
		{
			int key = a[i];
			int j=i-1;
			while (j>=0 && key<a[j])
			{
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=key;
		}
	
	}
	public void binaryInsertSort(){  
		int len=a.length;
        for (int i = 1; i < len; i++) {  
            if (a[i]<a[i-1]) {  
                int key = a[i];      
                int l = 0;            
                int r = i-1;  
                int m=0;
                while(l<=r){  
                    m = (l+r)/2;   
                    if (a[m]<key) {    
                        l = l+ 1;              
                    }else {                  
                        r = r - 1;  
                    }  
                }  
                for (int j = i; j>l; j--) {  
                    a[j]=a[j-1];
                }  

                a[l]=key;     
            }  
        }  
    }  
	/*
	public void insertSort()
	{
		int len=a.length;
		for (int i=1;i<len;i++)
		{
			int key=a[i];
			int j=i-1;
			while (j>0 && a[j]>key)
			{
				a[j+1]=a[j];
				j--;
			}
			a[j]=key;
		}
	}
	
	public void insertSort2()
	{
		int len=a.length;
		for (int i=1;i<len;i++)
		{
			int key=a[i];
			int j=i-1;
			while (j>1 && a[j]>key)
			{
				//a[j+1]=a[j];
				j=j/2;
				System.out.println("j="+j);
			}
			a[j]=key;
		}
	}
	*/
	/*
	public void selectSort()
	{
		
	}
		public int BinarySearch()
	{
		return -1;
	}
	*/


	
}
