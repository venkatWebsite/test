package ClientServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class test {

	public static void server()  extends chatClient throws IOException{

		try {
			ServerSocket ss = new ServerSocket(1151);
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
public static void main(String[] args) throws IOException, InterruptedException {
	test.server();
	Thread.sleep(2000);
	
	
	
	
}
}
