package Handle.VersionControl;

import java.io.*;
import java.net.Socket;

/**
 * Created by Sniper on 2018/4/19.
 */
public class ConfirmVersion {
    public boolean ConfirmVersion(String version){
        Socket socket = null;
        BufferedReader bufIn = null;
        BufferedWriter bufOut = null;
        try {
//            socket = new Socket("127.0.0.1", 54320);
            socket = new Socket("140.143.147.128", 54320);
            bufIn = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            bufOut = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            bufOut.write("version");
            bufOut.newLine();
            bufOut.flush();

            String flag = bufIn.readLine();
            System.out.println("server Version:"+flag);

            if (flag.equals(version)) {
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {
            System.out.println("error in ConfirmVersion````" + e);
            return true;
        }
    }
    public static void main(String[] args){
       System.out.println(new ConfirmVersion().ConfirmVersion("Beta 1"));
    }
}
