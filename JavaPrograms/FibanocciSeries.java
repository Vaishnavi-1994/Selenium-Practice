package JavaPrograms;

import java.util.Scanner;

public class FibanocciSeries 
{
public static void main(String[] args)
{
	System.out.println("How many Fibanocci Series in number?");
	Scanner input1=new Scanner(System.in);
	int count=input1.nextInt();
	System.out.println("Enter the First number");
	Scanner input2=new Scanner(System.in);
	int n1=input2.nextInt();
	System.out.println("Enter the Second number");
	Scanner input3=new Scanner(System.in);
	int n2=input3.nextInt(),n3 = 0;
	System.out.print(n1+" "+n2);
	for(int i=2;i<=count;++i)
	{
		n3=n1+n2;
		System.out.print(" "+n3);
		n1=n2;
		n2=n3;
	}
	
}
}
