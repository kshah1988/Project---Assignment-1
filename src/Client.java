import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.*;

//implemented the Client class for TCP/IP connection
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			Socket s = new Socket("127.0.0.1",1342); //defining the port number
			
			//created the bufferReader object to take the message into the input stream for server.
			BufferedReader echo = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			//create an output stream to send information to the server socket
			PrintWriter stringToEcho = new PrintWriter(s.getOutputStream(), true);
			
			
			Scanner sc= new Scanner(System.in); //created the scanner object to take the input
			String msgString;
			String response;
			
			do{
				//take the input from the scanner
				System.out.println("Enter the input string :");
				msgString = sc.nextLine();
				
				stringToEcho.println(msgString);
				
				//read the line until exit message is given
				if(!stringToEcho.equals("exit")){
					response = echo.readLine();
					System.out.println(response);
				}
				
				
			}while(!msgString.equals("exit"));
			
			
					
					
			
		} catch (UnknownHostException e) {			
			System.out.println("Host Error: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("Client Error: "+e.getMessage());
		}
		

	}

}//end of the class