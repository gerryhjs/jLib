package DP;

public class maxUdArray {
    public static void main(String[] args)
    {
        int a[]={10,21,35,25,18,6,22,33,55,66,77};
        System.out.print(calc(a));
    }

    private static int calc(int[] a)
    {
        int r[]=new int[a.length];
        int x[]=new int[a.length];
        int ans=0;
        for (int i=0;i<a.length;i++)
        {
            x[i]=-1;
            r[i]=1;
        }

        for (int i=a.length-2;i>=0;i--)
        {
            for (int j=i+1;j<a.length;j++)
            {
                if ((a[i]<a[j])&&(r[i]<(r[j]+1)))
                {
                    r[i]=r[j]+1;
                    x[i]=j;
                }
                if (r[ans] < r[i]) ans=i;
            }
        }
        for (int i=0;i<a.length;i++) {
            System.out.println(r[i]);
        }
        System.out.println("");
        int v=r[ans];
        while (ans!=-1)
        {
            System.out.println(a[ans]);
            ans=x[ans];
        }
        System.out.println("");
        return v;

    }

}
