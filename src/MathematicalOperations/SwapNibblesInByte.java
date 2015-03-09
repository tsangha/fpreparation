/*
VERY IMPORTANT NOTE:
In Java, before Java 8,
only char had unsigned declaration and representation. Other primitive datatypes didn't have unsigned declaration and representation
char is a primitive datatype with 16 bits for representation
Please read the following wikipedia page on "Criticism of Java": http://en.wikipedia.org/wiki/Criticism_of_Java

*/
package MathematicalOperations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SwapNibblesInByte {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Range of primitive type 'byte' in Java is from -128 to 127.");	
	    System.out.println("Enter a number which can be represented in a byte");
		System.out.println("NOTE: This program is only applicable for POSITIVE numbers");
	    byte c = in.nextByte();  // Enter a byte to the base 10
		System.out.println("Decimal representation after swapping nibbles: "+swapNibbles(c));
		}
		catch(InputMismatchException e){
			System.out.println("EXCEPTION: The number cannot be represented in one byte");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			in.close();
		}
	}
	public static int swapNibbles(int n){
		System.out.println("Original number decimal representation: "+n);
		System.out.println("Original number binary representation:\n"+Integer.toBinaryString(n));
		int left = ((n& 0x0F)<<4);     // Arrows and variable name MATCHES
		int right = ((n& 0xF0)>>4);    // Arrows and variable name MATCHES
		System.out.println("After swappning nibbles binary representation:\n"+Integer.toBinaryString(((n&0x0F)<<4|(n&0xF0)>>4)));
		return (left|right);
		/*
		 The above method can be written in a single line as:
			return ((n&0x0F)<<4|(n&0xF0)>>4);
		*/
	}
}
/*
Analysis:
	Time Complexity = O(1)
	Space Complexity=O(1)
*/
