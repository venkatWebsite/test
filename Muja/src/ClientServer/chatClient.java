package ClientServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class chatClient {
	
	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",4444);
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str="",str1="";
			while(!str.equals("stop")) {
				
				str1 =br.readLine();
				dout.writeUTF(str1);
				System.out.println(dout);
				dout.flush();
				
				str= din.readUTF();
				System.out.println("Server says: "+str);
			
				
				
			}
			dout.close();
			din.close();
			s.close();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
		
	}

}
