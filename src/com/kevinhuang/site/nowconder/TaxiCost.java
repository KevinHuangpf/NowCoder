package com.kevinhuang.site.nowconder;


import java.util.Scanner;

public class TaxiCost{
	public static void main(String[] args){
		//����
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int total = in.nextInt();
		int[] nums =new int[n];
		for(int i=0;i<n;i++){
			nums[i] = in.nextInt();
		}
		//���������
		sort(nums);
		int N = calculatCoin(n,total,nums);
		//���
		System.out.print(N);
		//����
		in.close();	
	}
	
	//����Ӳ������
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
		//Ǯ��������-1�����򷵻�Ӳ������
		return sum<total? -1:count;
	}
	
	//�����㷨
	
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