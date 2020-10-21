package JavaPrograms;

import java.util.Scanner;

public class SwitchProgram 
{
public static void main(String[] args) 
{
	Scanner input1=new Scanner(System.in);
	System.out.println("Enter the text");
	String getStringInput=input1.nextLine();
	char[] stringArray=getStringInput.toCharArray();
	System.out.println("Please Enter the selection");
	System.out.println("1.Show the String\n2.Reverse the String\n3.Floyd the String\n4.Left floyd String");
	Scanner input=new Scanner(System.in);
	int switchOption=input.nextInt();
	int number=stringArray.length-1;
	switch(switchOption)
	{
	case 1:
		
		for(int i=0;i<=stringArray.length-1;i++)
		{
			System.out.print(stringArray[i]);
		}
		
		break;
		
	case 2:
		for(int i=stringArray.length-1;i>=0;i--)
		{
			System.out.print(stringArray[i]);
		}
		break;
	case 3:
		
		
		for(int i=0;i<number;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print(stringArray[i]+ " ");
				number++;
			}
			System.out.println();
		}
		break;
		
	case 4:
		
		for(int i=0;i<=number;i++)
		{
			for (int j = 2*(number-i); j >=0; j--)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++)
			{
				System.out.print( " "+stringArray[i]);
			}
			System.out.println();
		}
		break;
	}
	
	
}
}
