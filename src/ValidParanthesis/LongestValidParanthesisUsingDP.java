/*
Question:
	Given a string containing just the characters '(' and ')',
	find the length of the longest valid (well-formed) parentheses substring.

Example: For "(()", the longest valid parentheses substring is "()", which has length = 2.
Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
	
Question and Answer Source:
	http://rleetcode.blogspot.com/2014/01/longest-valid-parentheses.html
*/		
		
		
package ValidParanthesis;

import java.util.Stack;

public class LongestValidParanthesisUsingDP {
	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")))("));
		System.out.println(longestValidParentheses(")))()"));
		System.out.println(longestValidParentheses(")))()(())("));
	}
	 public static int longestValidParentheses(String s) {
	        if (s==null||s.length()==0){
	            return 0;
	        }
	        int last=0;
	        int maxLen=0;
	        Stack<Integer> stack=new Stack<Integer>();
	        for (int i=0; i<s.length();i++){
	            if (s.charAt(i)=='('){
	                stack.push(i);
	            }
	            else{
	                if (stack.isEmpty()){
	                    // record the position before first left parenthesis
	                    last=i;
	                }
	                else{
	                    stack.pop();
	                    
	                    // if stack is empty mean the positon before the valid left parenthesis is "last"
	                    if (stack.isEmpty()){
	                        maxLen=Math.max(i-last, maxLen);
	                    }
	                    else{
	                      // if stack is not empty, then for current i the longest valid parenthesis length is 
	                      // i-stack.peek()
	                       maxLen=Math.max(i-stack.peek(),maxLen);  
	                    }
	                   
	                    
	                }
	            }
	        }
	        return maxLen;
	    }
}
/*
Analysis:
Time Complexity = O(n)
Space Complexity = O(n)
*/