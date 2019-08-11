package ClientServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class chatServer {
	//venkat
	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(4443);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str ="", str2 ="";
			while(!str.equals("stop")) {
				
				str= din.readUTF();
				System.out.println("Venkat: "+str);
				str2 =br.readLine();
				dout.writeUTF(str2);
				dout.flush();
				
			}
			din.close();
			s.close();
			ss.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
