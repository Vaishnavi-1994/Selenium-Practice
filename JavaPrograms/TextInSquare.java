package JavaPrograms;

import java.util.Scanner;

public class TextInSquare 
{
public static void main(String[] args)
{
	System.out.println("Enter the String");
	Scanner input =new Scanner(System.in);
	String textUserInput=input.nextLine();
	char[] getString=textUserInput.toCharArray();
	int sizeOfString=getString.length;
	for (int i = 0; i < getString.length; i++) 
	{
		System.out.print(getString[i]+" ");
	}
	System.out.println();
	for (int i = 1; i < getString.length; i++) 
	{
		System.out.print(getString[i]);
		for (int j = i; j < getString.length-1; j++) 
		{
			System.out.println();
		}
	}
	for (int i = sizeOfString-2; i>=0; i--)
	{
		System.out.print(" "+getString[i]);
	}
	for (int i = 0; i < getString.length; i++)
	{
		
	}
}
}
