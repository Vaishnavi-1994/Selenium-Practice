package Pages;

import Base.ProjectSpecificMethodsOlay;

public class GermanyHomePage extends ProjectSpecificMethodsOlay
{
	public GermanyHomePage urlGermanyHomePage()
	{
		driver.get("https://www.olaz.de/de-de");
		return this;
	}
	
}
