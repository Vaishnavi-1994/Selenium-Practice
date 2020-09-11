package Week3.Day1;

public class SmartPhone extends AndroidPhone
{
public void connectWhatsapp() 
{
	System.out.println("Smartphone connected to Whatsapp");
}
public static void main(String[] args) 
{
	SmartPhone myObj=new SmartPhone();
	myObj.sendMsg();
	myObj.makeCall();
	myObj.saveConatact();
	myObj.takeVideo();
	
}
}
