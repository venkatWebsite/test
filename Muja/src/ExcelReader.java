import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReader {

	public static void main(String[] args) throws Exception {
		ExcelReader data =new ExcelReader();
		//data.Excelread(0);
//		ArrayList<Object> username = data.Excelread(2);
//		for(int i=0;i<username.size();i++) {
//		System.out.println(username.get(i).toString());}
		
		data.filloAPI();
		
		}
		
		public ArrayList<Object> Excelread(int ColNo) throws Exception {

			FileInputStream fis = new FileInputStream("C:/Users/USER/Desktop/Book.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			Sheet sh= wb.getSheet("sheet1");
			
			Iterator<Row> rowitr=sh.iterator();
			rowitr.next();
			ArrayList<Object> list = new ArrayList<Object>();
			while(rowitr.hasNext()) {
				list.add(rowitr.next().getCell(ColNo).toString());
			
	}
			
	//System.out.println(list);
	return list;
}
		public void filloAPI() throws Exception {
			Fillo fillo = new Fillo();
			Connection conn= fillo.getConnection("C:/Users/USER/Desktop/Book.xlsx");
			Recordset rs =conn.executeQuery("select * from sheet1 where phone=''");
			while(rs.next()) {
			System.out.println(rs.getField("name")+rs.getField("email"));
			}
		}
		
}
