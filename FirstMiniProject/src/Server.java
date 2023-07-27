import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import database.Insert;
import serverGui.SeverGui;


//database에! CreateTable 부터 실행해주세요
//그 다음 Server 실행
//그 다음 Client 실행

//만일 CreateTable 실행이 안될경우!
//SQLite3 Referenced Libraies 다시 연결해주세요

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		new SeverGui();
		
		try {
			serverSocket = new ServerSocket(8888);
		} catch(IOException e) {
			e.printStackTrace();
		}


		while(true) {
			try {
				System.out.println("소켓생성완료");
				Socket socket = serverSocket.accept();
				OutputStream out = socket.getOutputStream();

				// 소켓의 입력스트림을 얻는다.
				InputStream in = socket.getInputStream();
				DataInputStream dis = new DataInputStream(in);

				String client_msg = dis.readUTF();
				System.out.println(client_msg);

				String[] res = client_msg.split(" ");

				new Insert(res[0], res[1]);
				// 소켓으로 부터 받은 데이터를 출력한다.
				System.out.println("클라이언트로부터 받은 메시지 :"+res[0]+" "+res[1]);      
				System.out.println("연결을 종료합니다.");

				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while
	} // main
}

