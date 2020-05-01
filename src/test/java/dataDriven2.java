import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven2 {


	public static ArrayList<String> getExcelData(String Efield, String Efield1, String Efield2) throws IOException 
	{

		// TODO Auto-generated method stub

		//File Input Stream argument
		ArrayList<String> Values=new ArrayList<String>();
		ArrayList<String> Values2=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("/Users/pos/Documents/Test1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0; i<sheets; i++)
		{
	        if(workbook.getSheetName(i).equalsIgnoreCase(Efield)){
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
				
				if(value.getStringCellValue().equalsIgnoreCase(Efield1))
				{
					column=k;
				
				}
				
			k++;}
			
			
		
			//Iterate through column (By iterating through entire rows and in column)
			while(rows.hasNext()) 
			{
				Row r = rows.next();
				
			
		try { 
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(Efield2))
				{
			
					
					Iterator<Cell> cv=r.cellIterator();
				
					
					while(cv.hasNext()) 
					{
						Cell c=cv.next();
						
						if(c.getCellType()==CellType.STRING) {Values.add(c.getStringCellValue());}
						else {Values.add(NumberToTextConverter.toText(c.getNumericCellValue()));}
					}
				
					
				
					
				for(int q=0; q<Values.size(); q++) 
				{
					String Values1;
					
					if(Values.size()==3) 
					{
						Values1 = Values.get(1) + "=" + Values.get(2);
						
						Values.clear();
						
						Values2.add(Values1);
					}
					else if(Values.size()==4){	
						
						Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3);
					
					Values.clear();
					
					Values2.add(Values1);}
					
	               else if(Values.size()==6){	
						
					Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3) +"&" +Values.get(4)+ "="+Values.get(5);
					
					Values.clear();
					
					Values2.add(Values1);}
					
	               else if(Values.size()==8){	
						
						Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3) +"&" +Values.get(4)+ "="+Values.get(5)+"&" +Values.get(6)+ "="+Values.get(7);
						
						Values.clear();
						
						Values2.add(Values1);}
					
	            else if(Values.size()==10){	
						
						Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3) +"&" +Values.get(4)+ "="+Values.get(5)+"&" +Values.get(6)+ "="+Values.get(7)+"&" +Values.get(8)+ "="+Values.get(9);
						
						Values.clear();
						
						Values2.add(Values1);}
	               else if(Values.size()==12){	
						
	      						Values1 = Values.get(1) + ":" + Values.get(2) + "=" + Values.get(3) +"&" +Values.get(4)+ "="+Values.get(5)+"&" +Values.get(6)+ "="+Values.get(7)+"&" +Values.get(8)+ "="+Values.get(9)+"&" +Values.get(10)+ "="+Values.get(11);
	      						
	      						Values.clear();
	      						
	      						Values2.add(Values1);} 
				
				}
				
				for(String g: Values2) 
				{
					if (g.contains("&0"))
					{
					String h = g.replaceAll("&0=0", "");
					Values2.remove(g);
						Values2.add(h);
					}
				}
				
				for(String g: Values2) 
				{
					
					if (g.contains("=0"))
					{
						if(g.contains("Date") || g.contains("From") || g.contains("To")) {}
						else{String h = g.replaceAll("=0", "");
					Values2.remove(g);
						Values2.add(h);
						}}
				}
				for(String g: Values2) 
				{
					if (g.contains("0:"))
					{
					String h = g.replaceAll("0:", "");
					Values2.remove(g);
						Values2.add(h);
					}
				}
				
				
				}
		
				}
		catch(Exception NoValue) {}
				
			}
			
			
	        }
		}
			
	return Values2;
	}



	
}
