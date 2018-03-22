package com.kevinhuang.site.nowconder;

import java.util.Scanner;

public class Necklace {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();//宝石种类数目
	        int m = sc.nextInt();//需要的总宝石数
	        int[][] arr = new int[n][2];
	        for (int i = 0; i < n; i++) {
	            arr[i][0] = sc.nextInt();
	            arr[i][1] = sc.nextInt();
	        }
	        sc.close();
	        System.out.println(method(n, m, arr));
	    }
	    //妞妞项链题
	    public static long method(int n, int m, int[][] arr){
	        long[][] dp = new long[n][m + 1];
	        for(int i = arr[0][0]; i <= arr[0][1]; i++){
	            dp[0][i] = 1;
	        }
	        for(int i = 1; i < n; i++){
//	          for(int j = 0; j < m + 1; j++){
//	              int left = Math.max(0, j - arr[i][1]);
//	              int right = Math.max(0, j - arr[i][0]);
//	              for(int k = left; k <= right; k++){
//	                  dp[i][j] += dp[i - 1][k];
//	              }
//	          }
	            for(int k = arr[i][0]; k <= arr[i][1]; k++){
	                for(int j = m; j >= k; j--){
	                    dp[i][j] += dp[i-1][j - k] ;
	                }
	            }
	        }
	        return dp[n - 1][m];
	    }
	}

