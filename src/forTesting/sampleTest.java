package forTesting;

public class sampleTest {
public static void main(String[] args) {
	int[] array = new int[10]; // declare an array with 10 rows
	
	int[][] multiDimensional = new int[5][10]; // declare an array with 5 rows and 10 columns
	
	System.out.println(array.length);	// get the number of rows
	System.out.println("Number of Rows of multi dimentional array: "+multiDimensional.length);  // get the number of rows
	System.out.println("Number of Columns of multi dimentional array: "+multiDimensional[0].length); // get the number of columns
}
}


/*
	Output:
	10
	Number of Rows of multi dimentional array: 5
	Number of Columns of multi dimentional array: 10
*/