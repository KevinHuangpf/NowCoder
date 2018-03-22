package com.kevinhuang.site.nowconder;

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();//字符串
        
        String[] temp = str.split("");//字符串
        int[] intArray = new int[temp.length];//int类型数组
        
        for(int i=0;i<temp.length;i++)
        {
        	intArray[i] = Integer.parseInt(temp[i]);//整数数组
        }       

       
        System.out.println(minInt(intArray));


    }
    
    public static int minInt(int[] array){
		
    	int n=array.length;
    	int max=0;
    	sort(array);    	
    	for(int index=n-1;index>=0;index--){
    		max+=array[index]*Math.pow(10,index);
    	}   	

    	
    	//sort(array);
    	for(int i=0;i<=9;i++){
    		if(i==Arrays.binarySearch(array, i))
    			continue;
    		else 
    			return i;
    	}
    	for(int i=0;i<=9;i++){
    		if(i==Arrays.binarySearch(array, i))
    			continue;
    		else 
    			return i;
    	} 
    	 	
    	for(int i=0;i<=9;i++){
    		if(i==Arrays.binarySearch(array, i))
    			continue;
    		else 
    			return i;
    	}
    	
    	return -1;   	
    	
  	
    }
    
    
    
   //Search
    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length-1;
     
        while (low <= high) {
            int mid = (low + high) >> 1;
            int midVal = a[mid];
     
            if (midVal < key)
            low = mid + 1;
            else if (midVal > key)
            high = mid - 1;
            else
            return mid; // key found
        }
        return -(low + 1);  // key not found.
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
