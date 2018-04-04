import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       try{
           Client client = new Client();

           client.sendNametoServer();

           while(client.isAlive()){
               client.sendText();
           }


       }catch (Exception e){
           e.printStackTrace();
       }


    }
}
