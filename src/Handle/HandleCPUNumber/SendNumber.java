package Handle.HandleCPUNumber;

import java.io.*;
import java.net.Socket;

/**
 * Created by Sniper on 2018/4/16.
 */
public class SendNumber {
    public boolean Judge(String code) {
        Socket socket = null;
        BufferedReader bufIn = null;
        BufferedWriter bufOut = null;
//        if (true){
//            System.out.println(code);
//            return true;
//        }
//        if (code.equals("BFEBFBFF000806E9")||code.equals("BFEBFBFF000306C3")){
//            return true;
//        }
        try {
//            socket = new Socket("127.0.0.1", 54321);
            socket = new Socket("140.143.147.128", 54321);
            bufIn = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            bufOut = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            bufOut.write(code);
            bufOut.newLine();
            bufOut.flush();

            String flag = bufIn.readLine();
            System.out.println(flag);
            if (flag.equals("true")){
                return true;
            }else{
                return false;
            }
        } catch (IOException e) {
            System.out.println("error in SendNumber" + e);
            return true;
        }
    }
    public static void main(String[] args){
        new SendNumber().Judge("aaa");
        new SendNumber().Judge("bbb");
        new SendNumber().Judge("bbbbbb");
        new SendNumber().Judge("cccccc");
    }
}
