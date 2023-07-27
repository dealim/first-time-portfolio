package javaStudy;

import java.net.*;
import java.io.*;

public class TcpIpServer {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;

        try {
            // 서버 소켓을 생성하고 7777 포트에 바인딩합니다.
            serverSocket = new ServerSocket(7777);
            System.out.println("서버가 준비되었습니다.");
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");

            // 클라이언트로부터 출력 스트림을 가져옵니다.
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            // 클라이언트로 메시지를 전송합니다.
            dos.writeUTF("안녕하세요. 서버입니다.");
            System.out.println("데이터를 전송했습니다.");

            // 소켓과 데이터 스트림을 닫습니다.
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
} 
