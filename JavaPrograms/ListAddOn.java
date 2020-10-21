package JavaPrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListAddOn
{
public static void main(String[] args) throws IOException, Exception 
{
	//Creating a List
	List<String> list1=new ArrayList<String>();
	System.out.println("Enter the number of data to added");
	Scanner inputNumber=new Scanner(System.in);
	int count=inputNumber.nextInt();
	for (int i = 1; i<=count; i++)
	{
		System.out.println("Enter the value for index "+i);
		Scanner input=new Scanner(System.in);
		String dataList=input.nextLine();
		list1.add(dataList);
	}	
	System.out.println("List Values is :\n");
	for (String tempList : list1)
	{
		System.out.println(tempList);
	}
	ListIterator<String> itr=list1.listIterator();    
    System.out.println("Traversing elements in forward direction");    
    while(itr.hasNext()){    
          
    System.out.println("index:"+itr.nextIndex()+" value:"+itr.next());    
    }    
    System.out.println("Traversing elements in backward direction");    
    while(itr.hasPrevious()){    
      
    System.out.println("index:"+itr.previousIndex()+" value:"+itr.previous());    
    }    
    FileInputStream inputStream = new FileInputStream("./data/workbookdata.xlsx");
    Workbook workbook = WorkbookFactory.create(inputStream);
    //Create the new workbook
    XSSFWorkbook wb=new XSSFWorkbook();
    //cretae sheet
    XSSFSheet wbsheet=wb.createSheet("Trial data");
    //file output
    FileOutputStream fileOut = new FileOutputStream("workbookdata.xlsx");
    wb.write(fileOut);
   
    
}
}
