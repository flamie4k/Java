import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThirdServer {
    public static void main(String[] args) {
        int PORT = 5555;
        try{
            ServerSocket thirdServer = new ServerSocket(PORT);
            System.out.println("Server Running at port"+PORT);
            Socket thirdSocket = thirdServer.accept();
            
            DataInputStream din = new DataInputStream(thirdSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(thirdSocket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String recieve_client = "",send_response="";
            while(!recieve_client.equals("stop")){
                recieve_client = din.readUTF();
                System.out.println("From Client :" + recieve_client);
                send_response = br.readLine();
                dos.writeUTF(send_response);
                dos.flush();
            }
            br.close();
            dos.close();
            din.close();
            thirdServer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}
