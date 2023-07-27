package javaStudy;

import java.net.*;
import java.io.*;

public class TcpIpClient {
    public static void main(String args[]) {
        try {
            String serverIp = "127.0.0.1";

            System.out.println("서버에 접속합니다. 서버 IP: " + serverIp);
            // 서버에 접속하고 소켓을 생성합니다.
            Socket socket = new Socket(serverIp, 7777);

            // 서버로부터 데이터를 수신할 준비를 합니다.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            // 서버로부터 전송된 메시지를 출력합니다.
            System.out.println("서버로부터 받은 메시지: " + dis.readUTF());
            System.out.println("연결을 종료합니다.");

            // 소켓과 데이터 스트림을 닫습니다.
            dis.close();
            socket.close();
            System.out.println("연결이 종료되었습니다.");
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
} // class
