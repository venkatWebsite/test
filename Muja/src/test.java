import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cucumber.deps.com.thoughtworks.xstream.core.ReferenceByIdMarshaller;

public class test {
	public static FileInputStream fis;
	public static XSSFWorkbook wb;

	public static void main(String[] args) {

		String nameVal = null;
		try {
			fis = new FileInputStream("C:/Users/USER/Desktop/newSheet.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sh = wb.getSheetAt(0);

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int i=1; i<sh.getLastRowNum();i++) {


			nameVal= sh.getRow(i).getCell(0).getStringCellValue();
			if(hm.get(nameVal)!= null) {
	
				hm.put(nameVal, hm.get(nameVal)+1);
			}else {

				hm.put(nameVal, 1);
			}
		}
		
		
		List<Entry<String,Integer>> list = new LinkedList<Entry<String,Integer>>(hm.entrySet());
		
	Collections.sort(list, new Comparator<Entry<String, Integer>>() {

		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			return o1.getValue().compareTo(o2.getValue());
		}
		
	});

	for (Entry<String, Integer> entry : list) {
		
		System.out.println(entry.getKey() +" has "+entry.getValue()+ " open tickest");
		
		
	}



	}
}
