package DP;

public class ulBag {




//value[i][j]表示剩余i个空间内前j个物品能容纳的最大价值

    public static void main(String[] args)
    {
        new ulBag().run(1000, new int[]{20, 30,40}, new int[]{20, 35,50});
    }
    public  void run(int weight,int[] itemWeight,int[] itemValue)
    {
        int itemNum=itemWeight.length;
        int[][] value=new int[weight+1][itemNum+1];//weight 第x件物品拿不拿
        for (int i=1;i<=weight;i++)
            for(int j=0;j<itemNum;j++)
            {
                    value[i][j]=max(get(value,i,j-1),get(value,i-1,j),get(value,i-itemWeight[j],j,itemValue[j]));
                    System.out.println(i+"-"+j+":"+value[i][j]);
            }
        System.out.println(value[weight][itemNum-1]);
    }
    private int get(int[][] x, int i, int j)
    {
        if ((i>=0) && (j>=0)) return x[i][j];
        return 0;
    }

    private int get(int[][] x, int i, int j, int addtion)
    {
        if ((i>=0) && (j>=0)) return x[i][j]+addtion;
        return 0;
    }

    private int max(int... input)
    {
        int max=-99999;
        for (int Scanner :input)
        {
            if (Scanner>max) max=Scanner;
        }
        return max;
    }



}
