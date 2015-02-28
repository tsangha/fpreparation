/*
Question: Dynamic programming problem: Coin change problem: 
	Find the minimum number of coins required to make change 
	for a given sum (given unlimited cumber of N different denominations coin)

Question And Answer Source: Facebook Interview
http://www.careercup.com/question?id=14405712
http://www.careercup.com/question?id=3753407
http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/		

IMP Source: https://www.youtube.com/watch?v=GafjS0FfAC0
*/
package CoinDenominations;

import java.util.Arrays;
import java.util.Scanner;

public class UsingDynamicProgramming {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of denominations");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the denomination values");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Enter the amount you need MIN COIN change for");
			int amount = in.nextInt();
			System.out.println("The MIN COINS required to form the amount is: "+coins(a,amount));
		}
		finally{
			in.close();
			}
	}

	private static int coins( int[] coins, int amount ) {
	// This is a DP question
		
		int[] minCoins = new int[amount+1];  // table of min_coins where the iterator i is AMOUNT
		// EXAMPLE: minCoins[10] represents minCoins required for making amount=10

		Arrays.fill( minCoins, Integer.MAX_VALUE); // VERY IMP STEP: Let Integer.MAX_VALUE be the min_coins required for all amounts
		minCoins[0] = 0;

		for ( int i = 1; i < minCoins.length; i++ ) {
			for ( int j = 0; j < coins.length; j++ ) {
				if ( coins[j] <= i &&   // CURRENT denomination is less than or equal to CURRENT AMOUNT
						minCoins[i - coins[j]] + 1 < minCoins[i] ) // minCoins[CURRENT AMOUNT - CURRENT DENOMINATION]+1 is less than minCoins[CURRENT AMOUNT]
					{                 
					minCoins[i] = minCoins[i - coins[j]] + 1; 
	                }
	                
				}
	        }

	        return minCoins[amount];
	        
	    	
			/*
			 * VERY VERY VERY VERY IMP NOTE: Please read the comments of this method VERY CAREFULLY to understand the program
			 * Also watch the video -> https://www.youtube.com/watch?v=GafjS0FfAC0
			 */
	}
}