package clientGui;
import java.net.*;

import model.Person;

import java.io.*;
public class Event {
	
	public Event(Person p) {

		try {
			String serverIp = "127.0.0.1";

			System.out.println("서버에 연결중입니다. 서버IP :" + serverIp);
			Socket socket = new Socket(serverIp, 8888); 

			// 소켓의 출력스트림을 얻는다.
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			String msg = p.toString();
			dos.writeUTF(msg);
			// 스트림과 소켓을 닫는다.
			dos.close();
			socket.close();
			System.out.println("연결이 종료되었습니다.");
		} catch(ConnectException ce) {
			ce.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();  
		}  
	} 
}


