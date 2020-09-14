
import java.io.*; 
import java.net.*; 

class CSenderClient{ 
  public static void main(String argv[]) throws Exception
  { 

	String name;
	String msg; 
	String newmsg; 
	String modified; 
	String newmodified;
	String age;
      
      	BufferedReader inFromUser =  new BufferedReader(new InputStreamReader(System.in));
      
      	Socket clientSocket = new Socket("127.0.0.1", 6789); 

	

      	DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
      
      	BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
	System.out.println("For entering the server, you need to provide your details:");
	System.out.println("Enter your name:");
	name = inFromUser.readLine();
	outToServer.writeBytes(name + '\n'); 
	System.out.println("Enter your age");
	age = inFromUser.readLine();
	outToServer.writeBytes(age + '\n'); 
	
	

	System.out.println("Enter the plain text you want to encrypt:");

      	msg = inFromUser.readLine(); 

      	outToServer.writeBytes(msg + '\n'); 

     	modified = inFromServer.readLine(); 

      	System.out.println("FROM SERVER: " + modified); 
	
	byte b[] = new byte[2000];
	
	
	InputStream is = clientSocket.getInputStream();
	FileOutputStream fr = new FileOutputStream("test2.txt");
	
	is.read(b,0,b.length);
	
	fr.write(b,0,b.length);	
	
	System.out.println("You just recieved a file from server");

     clientSocket.close(); 
  } 
}


