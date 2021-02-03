package test;

import java.util.Stack;

public class test1 {
  public static void main(String[] args) {
    Stack<String> stk= new Stack<>();
    stk.push("hi");
    stk.push("bad");
    while(stk.peek()!="bad") {
    
    System.out.println(stk.pop());
			
		}
    System.out.println(stk.pop());
    
  }
}
