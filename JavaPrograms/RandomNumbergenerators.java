package JavaPrograms;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbergenerators<Static>
{
public static void main(String[] args) 
{
	System.out.println("How many random numbers you want?");
	Scanner input=new Scanner(System.in);
	int rows=input.nextInt();
	System.out.println("The minimum number number is 0");
	System.out.println("Enter maximum number");
	int max=input.nextInt();
	System.out.println("The random numbers are Int : ");
	Random randomNumber=new Random();
	for(int i=1;i<=rows;i++)
	{
		System.out.println(randomNumber.nextInt(max));
	}
	System.out.println();
	System.out.println("The random numbers are double : ");
	for(int i=1;i<=rows;i++)
	{
		System.out.println(randomNumber.nextDouble());
		
	}
	System.out.println();
	System.out.println("The random numbers are float : ");
	for(int i=1;i<=rows;i++)
	{
		System.out.println(randomNumber.nextFloat());
	}
	
}
}
