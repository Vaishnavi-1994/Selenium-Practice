package JavaPrograms;

import java.util.Scanner;

public class FloydTriangle 
{
	public static void main(String[] args)
	{
		//Declare variable
		int rows,counter,j,number=1;
		Scanner input =new Scanner(System.in);
		System.out.println("Enter the number of rows");
		rows=input.nextInt();
		System.out.println("**************************");
		System.out.println("Floyd Traingle");
		System.out.println("**************************");
		//Rows
		for(counter=1;counter<=rows;counter++)
		{
			//Coulumns
			for(j=1;j<=counter;j++)
			{
				System.out.print(number+" ");
				number++;
			}
				System.out.println();
		}
		
		
	}
}
