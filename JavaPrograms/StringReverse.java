package JavaPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class StringReverse
{
	public static void main(String[] args) 
	{
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the String");
		String getStringInput=input.nextLine();
		System.out.println("Using Reverse Method");	
		StringBuilder getStringInput1 = new StringBuilder(); 
		//append
		getStringInput1.append(getStringInput);
		//reverse
		getStringInput1 = getStringInput1.reverse(); 
		System.out.println(getStringInput1);
		//Using char Array
		System.out.println("Using Char array");
		char[] charArray=getStringInput.toCharArray();
		for (int i = charArray.length-1; i >=0; i--)
		{
			System.out.print(charArray[i]);
		}
		//List
		System.out.println();
		//using by List iterator
		System.out.println("using by List iterator");
		
		List<Character> reverseList = new ArrayList<Character>();
		for (Character c : charArray)
		{
			reverseList.add(c);
		}
		Collections.reverse(reverseList);
		ListIterator li=reverseList.listIterator();
		while (li.hasNext()) 
            System.out.print(li.next()); 
		
		
	}

}
