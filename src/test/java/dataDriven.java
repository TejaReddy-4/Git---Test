import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {


	public static ArrayList<String> getExcelData(String Efield) throws IOException 
	{

		// TODO Auto-generated method stub

		//File Input Stream argument
		ArrayList<String> Values=new ArrayList<String>();
		
		FileInputStream fis=new FileInputStream("/Users/pos/Documents/Test1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0; i<sheets; i++)
		{
            if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")){
			XSSFSheet sheet= workbook.getSheetAt(i);
			
			//Identify Testcases column by scanning the entire 1st row
			Iterator<Row> rows= sheet.iterator();  //sheet is collection of rows (entire row - it checks entire rows to find the row the element present in)
			Row firstrow= rows.next();
			
			Iterator<Cell> ce= firstrow.iterator(); //row is collection of cell
			
			int k=0;
			int column=0;
			while(ce.hasNext()) 
			{
				Cell value=ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
				{
					column=k;
				
				}
				
			k++;}
			
			System.out.println(column);
		
			//Iterate through column (By iterating through entire rows and in column)
			while(rows.hasNext()) 
			{
				Row r = rows.next();
				
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(Efield))
				{
				
					Iterator<Cell> cv=r.cellIterator();
					
					while(cv.hasNext()) 
					{
						Cell c=cv.next();
						if(c.getCellType()==CellType.STRING) {Values.add(c.getStringCellValue());}
						else {Values.add(NumberToTextConverter.toText(c.getNumericCellValue()));}
						
					}
					
				
				}
				
			}
			
			
            }
		}
			
	return Values;
	}
	
	public static void main(String[] args) throws IOException 
	{
		//dataDriven d =new dataDriven();
		//ArrayList data	= d.getExcelData("Purchase");
		//System.out.println(data.get(1));
		
		
		ArrayList data =  getExcelData("Login");
		
		System.out.println(data);
	}

	
}
