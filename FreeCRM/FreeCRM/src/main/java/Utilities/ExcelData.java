package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.api.cli.Main;



public class ExcelData {

	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	Row row;
	Cell cell;
	static String val;
	public Object[][] readData() throws Exception {

		fis= new FileInputStream(new File("C:\\Users\\USER\\Desktop\\Excel\\Test.xlsx"));
		wb= new XSSFWorkbook(fis);
		sh= wb.getSheetAt(0);
		DataFormatter df = new DataFormatter();
		/*DataFormatter df = new DataFormatter();

		Iterator<Row>rt =sh.rowIterator();

		while(rt.hasNext()) {
			row=rt.next();

			Iterator<Cell> ct = row.cellIterator();

			while(ct.hasNext()) {
				cell= ct.next();

				val=df.formatCellValue(cell);
				System.out.println(val);

			}


		}
		return val;*/
		System.out.println("Row --------"+ sh.getLastRowNum());
		System.out.println("column -------"+sh.getRow(0).getLastCellNum());
Object[][] obj= new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
		for(int i=0;i<=sh.getLastRowNum();i++) {
			for(int j=0;j<sh.getRow(0).getLastCellNum();j++) {
		/*		if(df.formatCellValue(sh.getRow(i).getCell(j)).isEmpty()) {
					obj=null;
					break;
				}*/
				System.out.println(i+"    "+j);
				obj[i][j] =df.formatCellValue(sh.getRow(i).getCell(j));
				System.out.println(obj[i][j]);
				System.out.println("--------------");
			}
		}
		return obj;

	}
	public static void main(String[] args) throws Exception {
		ExcelData ed = new ExcelData();

		ed.readData();


	}
}
