package JavaPrograms;

import java.util.Scanner;

public class PatternProgram
{
public static void main(String[] args) 
{
	Scanner input=new Scanner(System.in);
	System.out.println("How many stars you want?");
	int count=input.nextInt();
	System.out.println("Enter the options");
	System.out.println("1.Pattern from Right\n2.Pattern from Left");
	Scanner input2=new Scanner(System.in);
	int switchOption=input2.nextInt();
	switch(switchOption)
	{
	case 1:
		for (int i = 0; i <=count; i++)
		{
			for (int j = 0; j <=i; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		break;
		
	case 2:
	
		for (int i = 0; i <count; i++)
		{
			for (int j = 2*(count-i); j >=0; j--)
			{
				System.out.print(" ");
			}
			for (int j = 0; j <=i; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
}
}
