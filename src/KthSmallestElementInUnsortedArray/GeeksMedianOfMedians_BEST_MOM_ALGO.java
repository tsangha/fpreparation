
/*
 * Question: Calculate the kth smallest element in the array
 * Solution Source: Java Implementation of http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/
 * Algorthm Source: http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/
 * OTHER IMP RESOURCE: MIT EXPLAINING THIS ALGORITHM HERE,
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-design-and-analysis-of-algorithms-spring-2012/lecture-notes/MIT6_046JS12_lec01.pdf
 */

package KthSmallestElementInUnsortedArray;

import java.util.Arrays;
import java.util.Scanner;

public class GeeksMedianOfMedians_BEST_MOM_ALGO {
	// A simple function to find median of arr[].  This is called
	// only for an array of size 5 in this program.
	public static int findMedian(int[] arr, int left, int totalElements)
	{
		/* Arrays.sort method description
		public static void sort(int[] a,
        int fromIndex,    // inclusive index
        int toIndex)      // exclusive index
		 */
	    Arrays.sort(arr, left, left+totalElements);  // Sort the array
	    int medianIndex = left+totalElements/2;
	    return arr[medianIndex];   // Return middle element
	}
	 
	// Returns k'th smallest element in arr[l..r] in worst case
	// linear time. ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
	public static int kthSmallest(int arr[], int l, int r, int k)
	{
	    // If k is smaller than number of elements in array
	    if (k > 0 && k <= r - l + 1)                          // (r-l+1) = number of elements within the range arr[l...r]. NOTE: DONOT REPLACE (r-l+1) with a.length
	    {
	        int n = r-l+1; // Number of elements to be considered within the range arr[l..r]
	 
	        // Divide arr[] in groups of size 5, calculate median
	        // of every group and store it in median[] array.
	        int i=0; 
	        int[] median=new int[(n+4)/5]; // There will be floor((n+4)/5) groups;
	        for (i=0; i<n/5; i++)
	            median[i] = findMedian(arr, l+i*5,5);
	        if (i*5 < n) //For last group with less than 5 elements. 
	       // Thus even the last part is sorted and median is taken from even the last part.
	       // If even number of elements in the last part Example 4 elements then 4/2 = 2nd index is taken in median array (RIGHTMOST index)
	       // If odd number of elements in the last part Example 3 elements then 3/2 = 1st index is taken in the median array (No issue in selecting median since odd number of elements)
	        {
	            median[i] = findMedian(arr,l+i*5,n%5); 
	            i++;     
	        }    
	        
	        // Find median of all medians using recursive call.
	        // If median[] has only one element, then no need
	        // of recursive call
	        int medOfMed = (i == 1)? median[i-1]:
	                                 kthSmallest(median, 0, i-1, i/2);
	        
	        
	        // Partition the array around a random element and
	        // get position of pivot element in sorted array
	        int pos = partition(arr, l, r, medOfMed);
	 
	        // If position is same as k
	        if (pos-l == k-1)
	            return arr[pos];
	        if (pos-l > k-1)  // If position is more, recur for left
	            return kthSmallest(arr, l, pos-1, k);
	 
	        // Else recur for right subarray
	        return kthSmallest(arr, pos+1, r, k-pos+l-1);
	    }
	 
	    // If k is more than number of elements in array
	    return Integer.MAX_VALUE;
	}
	 
	public static void swap(int[] arr, int index1, int index2)
	{
	    int temp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = temp;
	}
	 
	// It searches for x in arr[l..r], and partitions the array 
	// around x.
	public static int partition(int arr[], int l, int r, int x)
	{
	    // Search for x in arr[l..r] and move it to end
	    int i;
	    for (i=l; i<r; i++)
	        if (arr[i] == x)
	           break;
	    swap(arr,i, r);
	 
	    // Standard partition algorithm
	    i = l;
	    for (int j = l; j <= r - 1; j++)
	    {
	        if (arr[j] <= x)
	        {
	            swap(arr,i, j);
	            i++;
	        }
	    }
	    swap(arr,i, r);
	    return i;
	}
	 
	// Driver program to test above methods
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Enter the number of elements");
		int n = in.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the elements of the array");
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("Length of the array: "+a.length);
		System.out.println("Array elements are: "+Arrays.toString(a));
		System.out.println("Enter k to search for kth smallest number. Starts from 1 to "+a.length);
		int k = in.nextInt();   // Starts from 1 to a.length
		int res = kthSmallest(a,0, a.length-1, k);	
		System.out.println("Array elemnts using median of medians: "+Arrays.toString(a));
		System.out.println("Using median of medians: "+res);
		Arrays.sort(a);
		System.out.println("Using sorting: "+a[k-1]);
		System.out.println("Sorted array using sorting: "+Arrays.toString(a));
		}
		finally{
			in.close();
		}
	}
}
