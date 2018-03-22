package com.kevinhuang.site.nowconder;


import java.util.*;
public class MaxCE{
public static int optimum(int n,int k,int[][] s){
    int res = 0;
int[] max_num=new int[5];
    for(int i=0;i<n;i++){
            for(int j=0;j<5;j++){
                max_num[j]=Math.max(s[i][j],max_num[j]); //储存每列最大数
            }
        }
    if(k==1){
        for(int i=0;i<n;i++)
            {
                int temp=0;
                for(int j=0;j<5;j++)
                {
                    temp+=s[i][j];
                }
                res=Math.max(temp, res);
            }
    }
    else if(k==2){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){ //选择排序遍历
                int temp=0;
                    for(int h=0;h<5;h++)
                    {
                        temp+=Math.max(s[i][h], s[j][h]);
                    }
                    res=Math.max(temp, res);
            }
        }
    }else if(k==3){
        for(int i=0;i<n;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    for(int e=j+1;e<n;e++)
                    {
                        int temp=0;
                        for(int h=0;h<5;h++)
                        {
                            temp+=Math.max(s[i][h], Math.max(s[j][h], s[e][h]));
                        }
                        res=Math.max(temp, res);
                    }
                  
                }
            }
    }else if(k==4){
        for(int i=0;i<5;i++)
            {
                for(int j=i+1;j<5;j++)
                {
                    int temp=0;
                    for(int e=0;e<n;e++)
                    {
                        temp=Math.max(temp, s[e][i]+s[e][j]);
                    }
                    for(int h=0;h<5;h++)
                    {
                        if(h!=i && h!=j)
                            temp+=max_num[h];
                    }
                    res=Math.max(res, temp);
                }
            }
    }else{
        for(int i=0;i<5;i++)
            {
                res+=max_num[i];
            }
        }
        return res;
    }
     
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int s[][] = new int[n][5];
        for(int i=0;i<n;i++){
            for(int j=0;j<5;j++){
                s[i][j]=sc.nextInt();
            }
        }
        System.out.println(optimum(n,k,s));
    }
}