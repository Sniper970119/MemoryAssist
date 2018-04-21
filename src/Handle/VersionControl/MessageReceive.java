package Handle.VersionControl;

import java.io.*;
import java.net.Socket;

/**
 * Created by Sniper on 2018/4/20.
 */
public class MessageReceive {
    public String MessageReceive(){
        Socket socket = null;
        BufferedReader bufIn = null;
        BufferedWriter bufOut = null;
//        if (version.equals("")||version.equals("")){
//            return true;
//        }
        try {
//            socket = new Socket("127.0.0.1", 54322);
            socket = new Socket("140.143.147.128", 54322);
            bufIn = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            bufOut = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            bufOut.write("message");
            bufOut.newLine();
            bufOut.flush();

            String flag = null;
            String message = bufIn.readLine();
//            String message = null;
//            while ((flag = bufIn.readLine())!=null){
//                message+=flag;
//            }
            System.out.println(message);
            return message;

        } catch (IOException e) {
            System.out.println("error in MessageReceive" + e);
        }
        return null;
    }
    public static void main(String[] args){
        new MessageReceive().MessageReceive();
    }
}
