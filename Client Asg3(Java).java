import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class clientQB{
	public static void main(String[] args) throws 
UnknownHostException, IOException
	{
		System.out.println("Client started");
		Socket s = new Socket("192.168.11.129",7778);

		Date d = new Date();
		String dformat = "HH";
		DateFormat dateformat = new SimpleDateFormat(dformat);
		String fdate = dateformat.format(d);
			
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(fdate);
		
		Scanner s1 = new Scanner(s.getInputStream());
		String server_reply = s1.nextLine();

		System.out.println(server_reply);			

	}
}