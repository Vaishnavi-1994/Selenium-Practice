package Week3.Day1;

public class KVB extends RBI
{

public void loadInterestRate(String personalLoan)
{
	
	System.out.println("Loan interest rate for personal loan is :" +personalLoan+"%");
}
public static void main(String[] args) {
	

KVB myObj = new KVB();


myObj.loanInterestRate();
myObj.loanInterestRate("6");
myObj.loadInterestRate("12");

}
}