import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.bouncycastle.jcajce.provider.asymmetric.RSA;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class excel {
	public static void main(String[] args) throws Exception {
	int i,temp;
		Fillo fillo =new Fillo();
		Connection conn= fillo.getConnection("C:/Users/USER/Desktop/Book.xlsx");
		String strquery= "Select * from sheet1";
		ArrayList<String> data=new ArrayList<String>();
		
		Recordset rs= conn.executeQuery(strquery);
		
		//System.out.println(rs.getField("Details"));
		
		while(rs.next()) {
		//	String val=rs.getField("name");
        data.add(rs.getField("phone"));
        Arrays.sort(data.toArray());
		}
		for( i=0;i<data.size();i++) {
			for(int j=1;j<data.size();j++) {
				
				if(i<j) {
					//System.out.println(data.get(i));
					temp= j;
					j=i;
					i=temp;
	
				}
				
		}
			System.out.println(data);
	}

	}

}
