package JavaPrograms;

import java.util.Scanner;

public class QuotientAndRemainders
{
public static void main(String[] args)
{
	//Create object for java input
	Scanner input =new Scanner(System.in);
	System.out.println("Enter the First Number");
	//Intialize variable with user input
	int a =input.nextInt();
	//Intialize variable with user input
	System.out.println("Enter the Second Number");
	int b =input.nextInt();
	//Get Quotient
	int quotient=a/b;
	int remainder=a%b;
	System.out.println("Enter number is "+a+" and "+b+", the quotient is "+quotient);
	System.out.println("Enter number is "+a+" and "+b+", the remainder is "+remainder);
	
	
}
}
