package ClientServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class chatServer {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(4444);
			Socket s = ss.accept();
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str ="", str1 ="";
			while(!str.equals("stop")) {
				
				str= din.readUTF();
				System.out.println("client says: "+str);
				
				str1 =br.readLine();
				
				dout.writeUTF(str1);
				System.out.println(dout.toString());
				dout.flush();
				
			}
			din.close();
			dout.close();
			s.close();
			ss.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
