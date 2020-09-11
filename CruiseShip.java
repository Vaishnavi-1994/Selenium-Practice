package Week3.Day1;

public	class CruiseShip extends CargoShip
{
	public void maximumPassengers(int maximumPassengers) 
	{
	System.out.println("maximumPassengers "+maximumPassengers );
	}
	public void cruiseCategory(String cruiseCategory) 
	{
		System.out.println("Category is "+cruiseCategory);

	}

public static void main(String[] args) 
{
	CruiseShip myObj=new CruiseShip();
	myObj.shipName("River Ganges Heritage");
	myObj.shipBuiltYear("2004");
	myObj.cargoCapacityinTons(25000);
	myObj.maximumPassengers(600);
	myObj.cruiseCategory("Supreme");
	
	
	
}
}
