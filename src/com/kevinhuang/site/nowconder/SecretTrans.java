package com.kevinhuang.site.nowconder;

import java.util.Scanner;

public class SecretTrans {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("input secret:");
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()){
			String secret = input.nextLine();
			transCode(secret);
		}
		input.close();
	}
	
	
	public static void transCode(String secret){
		for(int i = 0; i<secret.length();i++){
			char ch = secret.charAt(i);
			if(ch>='a'&&ch<='z')
				System.out.print((char)(ch=='z'?'a':ch+1));
			else if(ch>='A'&&ch<='Z')
			System.out.print((char)(ch=='Z'?'a':ch+1));
			else
				System.out.print(ch);
		}
	}
}