/*
Question: Find Maximum size square sub-matrix with all 1s
Source: http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
Algorithm:
	1. create a solution matrix 
	2. Copy the first row as it is
	3. Copy the first column as it is
	4. iterate from 1st row and 1st column till the end
		 if(original[i][j]==1)
			change solution[i][j] to Math.min(Math.min(input[i][j-1],input[i-1][j]),input[i-1][j-1])+1;
		 Math.max(solution[i][j],max)
    5. return max*max
			
NOTE: This only works to find SQUARE SUB MATRIX
*/
package Histogram.LargestAreaRectangleInHistogram;

class MaximumSizeSquareSubMatrix{

	    public static void main(String[] args){
	        
	        int[][] knows = new int[][]{{1,0,0,1},
	                                    {0,1,1,1},
	                                    {0,1,1,0},
	                                    {1,1,1,0}};
	                                    
	                                    
	        System.out.println("The max area is: "+findLargest(knows));
	    }
	    public static int findLargest(int[][] a){

	        if(a==null||a.length==0)
	            return -1;
	        
	        int[][] aux = new int[a.length][a[0].length];
	        int max = 0;
	        
	        for(int i=0;i<a.length;i++)
	            aux[i][0] = a[i][0];
	            
	        for(int j=0;j<a[0].length;j++)
	            aux[0][j] = a[0][j];
	        
	        for(int i=1;i<a.length;i++){
	            for(int j=1;j<a[0].length;j++){
	                if(a[i][j]==1)
	                    aux[i][j] = Math.min(Math.min(a[i-1][j-1],a[i][j-1]),a[i-1][j])+1;
	                if(aux[i][j]>max)
	                    max=aux[i][j];
	            }
	        }
	       
	        
	        return max*max;
	        
	    }
	}
/*
 * Analaysis:
 * 			Time Complexity = O(m*n) where m = number of rows
 * 										   n = number of columns
 * 			Space Complexity = O(m*n)
*/