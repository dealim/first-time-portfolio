package javaStudy;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddrStudy {
	public static void main(String[] args) {
		InetAddress ip = null;
		InetAddress[] ipArray = null;
		try {
			ip = InetAddress.getByName("www.naver.com");
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName() : "   +ip.getHostName());
			System.out.println("getHostAddress() : "+ip.getHostAddress());
			System.out.println("toString() : "      +ip.toString());
		
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}