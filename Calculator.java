package Week3.Day1;

public class Calculator 
{
public void add(int a,int b) 
{
	System.out.println("The value of " +a + "and "+b);
}
public void add(int a,int b,int c)
{
	c=a+b;
	System.out.println("The add of "+c);
}
public void multiply(int a,int b) 
{
	System.out.println("The value of " +a + "and "+b);
}
public void multiply(int a,int b,int c)
{
	c=a*b;
	System.out.println("The multply of "+c);
}
public void divide(int a,int b)
{
	System.out.println("The value of " +a + "and "+b);
}
public void divide(int a,double b)
{
	b=a/b;
	System.out.println("The divide of "+b);
	}
public static void main(String[] args) 
{
	Calculator myCalc=new Calculator();
	myCalc.add(5, 3);
	myCalc.add(5, 3, 0);
	myCalc.multiply(5,5);
	myCalc.multiply(5,5,0);
	myCalc.divide(10, 5);
	myCalc.divide(10,5.0);
}
}
