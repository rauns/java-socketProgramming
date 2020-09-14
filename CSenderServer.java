import java.io.*; 
import java.net.*; 


class CSenderServer { 
   public static void main(String argv[]) throws Exception {

  	String msg; 

	String name;

	String age;

    	String modified; 


	int shift = 4;

	int len = 0;
	
	String newmessage="";

	String s = "";


    	ServerSocket welcomeSocket = new ServerSocket(6789); 

   		 while(true) {

           		Socket connectionSocket = welcomeSocket.accept(); 
           
          		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 

          		DataOutputStream outToClient =  new DataOutputStream(connectionSocket.getOutputStream()); 
			name = inFromClient.readLine(); 
			age= inFromClient.readLine(); 
			System.out.println("New Client has joined\nClient Name: "+name+"\nAge: "+age);
        		msg = inFromClient.readLine(); 
	
			System.out.println("Message in plain text from client: "+msg);
			len = msg.length();
			for(int x = 0; x < len; x++){
        		char c = (char)(msg.charAt(x) + shift);
        		if (c > 'z')
            		s += (char)(msg.charAt(x) - (26-shift));
        		else
            		s += (char)(msg.charAt(x) + shift);}	

        		modified = "Hi" +" "+name+" your encrypted text is "+s+'\n';
	

        		outToClient.writeBytes(modified); 
	
			System.out.println("Encrypted text "+s+" sent to "+name);
	
			FileInputStream fr= new FileInputStream("test.txt");
	
			byte b[] = new byte[2000];
	
			fr.read(b,0,b.length);
	
			OutputStream os = connectionSocket.getOutputStream();
			os.write(b,0,b.length);
	
			System.out.println("File sent to the client");
 			} 
  		} 
	} 


