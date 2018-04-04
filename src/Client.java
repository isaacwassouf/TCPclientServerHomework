import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    public Client(){
       try{
           socket =  new Socket("192.168.43.33",1234);

       }
       catch (Exception e){
           e.printStackTrace();
       }
    }

    public void sendNametoServer(){
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter your name please: ");
            String name = scanner.next();
            dataOutputStream.writeUTF("greetings");
            dataOutputStream.writeUTF(name);
            String response = dataInputStream.readUTF();
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void sendText(){

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            Scanner scanner =  new Scanner(System.in);
            System.out.println("enter your message please: ");
            String message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            String response= dataInputStream.readUTF();
            System.out.println(response);
            if (response.equals("bye")) {
                socket.close();
            }




        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public boolean isAlive(){
        return !socket.isClosed();
    }



}
