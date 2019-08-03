package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:/Users/USER/Desktop/newSheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(int i=0 ; i<sh.getLastRowNum(); i++) {

			String val = sh.getRow(i).getCell(0).getStringCellValue();
			if(hm.get(val)!=null) {
				hm.put(val, hm.get(val)+1);

			}else {
				hm.put(val, 1);
			}
		}
		System.out.println(hm);
		
		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(hm.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String,Integer>>() {

			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		for (Entry<String, Integer> entry : list) {
			System.out.println(entry);
		}
		
	}

}
