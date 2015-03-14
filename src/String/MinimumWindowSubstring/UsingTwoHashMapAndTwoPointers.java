/*
 * Question: You are given a set of unique characters and a string. 

Find the smallest substring of the string containing all the characters in the set. 

ex: 
Set : [a, b, c] 
String : "abbcbcba" 

Result: "cba"

Question Source: http://www.careercup.com/question?id=5092414932910080

 * Answer Source: http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 * 
 * IMP Sources:
https://linchicoding.wordpress.com/2014/08/20/leetcode-minimum-window-substring/
http://rleetcode.blogspot.com/2014/01/minimum-window-substring-java.html
http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
http://mattcb.blogspot.com/2012/12/minimum-window-subs	tring.html
*/
package String.MinimumWindowSubstring;

import java.util.Scanner;

public class UsingTwoHashMapAndTwoPointers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter sentence");
			String big = in.nextLine();
			System.out.println("Enter text which is small than sentence");
			String small = in.nextLine();
			System.out.println(minWindow(big.toCharArray(), small.toCharArray(), 0,0));
		}
		finally{
			in.close();
		}
	}
	
	// Returns false if no valid window is found. Else returns 
	// true and updates minWindowBegin and minWindowEnd with the 
	// starting and ending position of the minimum window.
	// Source: http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
	public static boolean minWindow(char[] S, char[] T, int minWindowBegin, int minWindowEnd) {
	  int sLen = S.length;
	  int tLen = T.length;
	  int[] needToFind = new int[256];
	 
	  for (int i = 0; i < tLen; i++)
	    needToFind[T[i]]++;
	 
	  int[] hasFound=new int[256];
	  int minWindowLen = Integer.MAX_VALUE;
	  int count = 0;
	  for (int begin = 0, end = 0; end < sLen; end++) {        // FOR LOOP of begin and end pointers
	    // skip characters not in T
	    if (needToFind[S[end]] == 0) 
	    	continue;
	    hasFound[S[end]]++;
	    if (hasFound[S[end]] <= needToFind[S[end]])
	      count++;
	 
	    // if window constraint is satisfied
	    if (count == tLen) {
	      // advance begin index as far right as possible,
	      // stop when advancing breaks window constraint.
	      // To understand this, refer here: http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html 
	      while (needToFind[S[begin]] == 0 || hasFound[S[begin]] > needToFind[S[begin]]) {
	    	  
	        if (hasFound[S[begin]] > needToFind[S[begin]])
	          hasFound[S[begin]]--;
	        
	        begin++;
	      }
	 
	      // update minWindow if a minimum length is met
	      int windowLen = end - begin + 1;
	      if (windowLen < minWindowLen) {
	        minWindowBegin = begin;
	        minWindowEnd = end;
	        minWindowLen = windowLen;
	      } // end if
	    } // end if
	  } // end for
	 
	  return (count == tLen) ? true : false;
	}
}
/*
Analysis:
Time Complexity = O(n) where n = length of big string(Sentence)   [O(n) considering substring() is O(1) in some languages but not in JAVA. In JAVA it is O(n)]
Space Complexity = O(1) since we use set of 256 characters which is constant memory
*/