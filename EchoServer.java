package Sd;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {
	public static Date data;
	public static void main(String[] args) {
		Scanner in;
		OutputStream outStream; 
		InputStream inStream;
		Socket incoming ;
		ServerSocket s;
		try {
			 s = new ServerSocket(8189);
			 incoming = s.accept();
			try {
				 inStream = incoming.getInputStream();
				 outStream = incoming.getOutputStream();

				in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
				out.println("Hello! Enter BYE to exit.");

				
				data = new Date();

				// echo client input
				boolean done = false;
				while (!done && in.hasNextLine()) {
					String line = in.nextLine();
					System.out.println(line);
					if (line.equals("data")) {
						out.println(data);

					}

					out.println("Echo: " + line);
					if (line.trim().equals("BYE"))
						done = true;
				}
			} finally {
				incoming.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
