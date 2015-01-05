package PowerSetFromSet;

import java.util.Scanner;

public class PowerSetOfIntegerArrayUsingBitIncrement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the size of the integer array");
			int n = in.nextInt();
			System.out.println("Enter the elements of the integer array for powerset calculation");
			int[] set = new int[n];
			for(int i=0;i<n;i++)
				 set[i] = in.nextInt();
			printPowerSet(set);
		}
		finally{
			in.close();
		}
	}

	private static void printPowerSet(int[] set) {
		for(int i=0;i<(int)Math.pow(2,set.length);i++){
			for(int j=0;j<set.length;j++){ // loop which checks which bit is set in integer i
				if(((i)&(1<<j))!=0) // HandRun this to understand how to check for set bits in an integer
					System.out.print(set[j]);
			}
			System.out.println();
		}
	}
}
/*
Analysis:
	Time Complexity = O(n*2^n)
	Space Complexity = O(1)*/