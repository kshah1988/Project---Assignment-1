import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;

//implemented the Server class for TCP/IP connection
public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			ServerSocket s1 = new ServerSocket(1342); // created a socket object from ServerSocket to listen the port.
			
			Socket ss = s1.accept(); //accept connections from clients
			int count=0;
			count++;
			System.out.println("SERVER: Client Connected");
			
			
			
			
			BufferedReader input = new BufferedReader(new InputStreamReader(ss.getInputStream()));
			PrintWriter output = new PrintWriter(ss.getOutputStream(),true);
			
			
			while(true){
				String msgString =input.readLine();
				String st=msgString;
				
				int result=0;
				
				//check if the message  from client is exit 
				if(msgString.equals("SERVER: exit")){
					break;
				}
				//functionality to show number of client connected
				else if(msgString.equalsIgnoreCase("COUNT")){
					msgString=Integer.toString(count);
					output.println("SERVER 515OK: Mesg from server: No. of Client connected:"+msgString);
				}
				else{
					
					//functionality to check the operators and operand and do the mathematical operation
					for(int i=0;i<st.length();i++)
					{
					  if(st.charAt(i)=='+')
					  {
					    result=Integer.parseInt(st.substring(0, i))+Integer.parseInt(st.substring(i+1, st.length()));
					    System.out.print("result="+result);
					  } 
					  
					  else if(st.charAt(i)=='-')
					  {
					    result=Integer.parseInt(st.substring(0, i))-Integer.parseInt(st.substring(i+1, st.length()));
					    System.out.print("result="+result);
					  }
					  else if(st.charAt(i)=='*')
					  {
					    result=Integer.parseInt(st.substring(0, i))*Integer.parseInt(st.substring(i+1, st.length()));
					    System.out.print("result="+result);
					  }
					  else if (st.charAt(i)=='/')
					  {
					    result=Integer.parseInt(st.substring(0, i))/Integer.parseInt(st.substring(i+1, st.length()));
					    System.out.print("result="+result);
					  }
					  else if(st.charAt(i)=='%')
					  {
						    result=Integer.parseInt(st.substring(0, i))%Integer.parseInt(st.substring(i+1, st.length()));
						    System.out.print("result="+result);
					  }			  
					
								
				}
				
				output.println("SERVER 515OK: Mesg from server:" +msgString+"="+result);
				
					
					
				}// else end						
						
				
				
			} // while ends here
			
		} catch (UnknownHostException e) {			
			System.out.println("Host Error: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("Client Error: "+e.getMessage());
		}
	}

}
