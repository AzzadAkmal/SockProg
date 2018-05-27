import java.net.ServerSocket;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.*;
import java.net.Socket;
import java.net.InetAddress;
import java.util.Date;
import java.net.UnknownHostException;

public class serverfortime{
	public static void main(String[] args) throws IOException
	{
		ServerSocket s1 = new ServerSocket(7778);
		System.out.println("Socket created");
		Socket ss = s1.accept();
				
		Scanner sc = new Scanner(ss.getInputStream());

		int d = Integer.parseInt(sc.nextLine());
		System.out.println(d);
				
		PrintStream p = new PrintStream(ss.getOutputStream());
		
		if(d <= 11)
		p.println("Good Morning");

		if(d == 12)
		p.println("Good Afternoon");

		if(d >= 13 && d <= 19)
		p.println("Good Evening");
		
		if(d >= 20)
		p.println("Good Night");
	
	}
}