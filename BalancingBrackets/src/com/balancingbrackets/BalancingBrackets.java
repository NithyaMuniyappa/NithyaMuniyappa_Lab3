package com.balancingbrackets;

import java.util.Stack;

public class BalancingBrackets 
{
  static boolean checkingBracketBalanacing(String bracketExpression)
{
	Stack<Character> stack= new Stack<Character>();
	for(int i=0;i<bracketExpression.length();i++)
	{
		char x=bracketExpression.charAt(i);
		if((x=='(')||(x=='{')||(x=='['))
		{
			stack.push(x);
			continue;
		}
		if(stack.isEmpty())
		{
			return false;
		}
		
		char check;
		switch(x)
		{
		case ')':
			check=stack.pop();
			if(check =='{' || check =='[')
				return false;
			break;
		case '}':
			check=stack.pop();
			if(check=='('||check=='[')
				return false;
			break;
		case ']':
			check=stack.pop();
			if(check=='('||check=='{')
				return false;
			break;
		}
	}
	return (stack.isEmpty());
}
  public static void main(String[] args)
  {
	  String bracketExpression="([{}])";
	  boolean result;
	  result=checkingBracketBalanacing(bracketExpression);
	  if(result)
	  {
		  System.out.println("The entered String has Balanced Brackets");
	  }
	  else
	  {
		  System.out.println("The entered String do not contain Balanced Brackets");
	  }
  }
}
