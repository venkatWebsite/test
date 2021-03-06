package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static final String path = "C:/Users/USER/Desktop/Book.xlsx";
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static Row row;
	
	public static void loadExcel() throws Exception {
		fis= new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet("sheet1");
		fis.close();
		wb.close();
	}

	public static Map<String,Map<String,String>> getData() throws Exception{
		if(sh==null) {
			loadExcel();
		}
		Map<String,Map<String,String>> superMap= new HashMap<String,Map<String,String>>();
		Map<String,String> myMap= new HashMap<String,String>();
		
		for(int i=1;i<sh.getLastRowNum()+1;i++) {
			row= sh.getRow(i);
			String Key= row.getCell(0).getStringCellValue();
			
			for(int j=1; j<row.getLastCellNum();j++) {
				String Value= row.getCell(j).getStringCellValue();
				myMap.put(Key, Value);
			}
			superMap.put("MasterData", myMap);
		}
		return superMap;
	}
	
	public static String getValue(String Keys) throws Exception {
		Map<String,String> myVal=getData().get("MasterData");
		String retVal= myVal.get(Keys);
		return retVal;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getValue("ven"));
	}
}
