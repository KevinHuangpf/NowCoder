package com.kevinhuang.site.nowconder;


import java.util.Scanner;

public class TaxiCost{
	public static void main(String[] args){
		//输入
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int total = in.nextInt();
		int[] nums =new int[n];
		for(int i=0;i<n;i++){
			nums[i] = in.nextInt();
		}
		//排序与计算
		sort(nums);
		int N = calculatCoin(n,total,nums);
		//输出
		System.out.print(N);
		//结束
		in.close();	
	}
	
	//计算硬币数量
	public static int calculatCoin(int n,int total,int[] nums){
		int count =0;
		int sum = 0;
		for(int j=0;j<n;j++){
			sum +=nums[j];
			count++;
			
			if(sum>=total){
				for(int k=count-1;k>=0;k--){
					if((sum-nums[k])>=total){
						count--;
						sum -=nums[k];
					}
				}
				break;
			}		
		}
		//钱不够返回-1，否则返回硬币数量
		return sum<total? -1:count;
	}
	
	//排序算法
	
	private static void sort(int[] a){
		sort(a,0,a.length-1);
	}	
	private static void exch(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}	
	private static void sort(int[] a,int lo,int hi){
		if(lo>hi) return;
		
		int lt=lo,i=lo+1,gt=hi;
		int v=a[lo];
		
		while(i<=gt){
			if(a[i]>v) exch(a,i,gt--);
			else if(a[i]<v) exch(a,lt++,i++);
			else i++;			
		}		
		//a[lo...lt-1]<=a[lt...gt]<a[gt+1...hi]
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	
}