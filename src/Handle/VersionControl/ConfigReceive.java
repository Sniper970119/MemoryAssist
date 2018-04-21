package Handle.VersionControl;

import java.io.*;
import java.net.Socket;

/**
 * Created by Sniper on 2018/4/20.
 */
public class ConfigReceive {
    public Boolean VersionReceive() {
        Socket socket = null;
        DataInputStream dataInputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = null;
//        if (true){
//            System.out.println("new Version");
//            return true;
//        }
        try {
//            socket = new Socket("127.0.0.1", 54326);
            socket = new Socket("140.143.147.128", 54326);
            dataInputStream = new DataInputStream(socket.getInputStream());
            String name = dataInputStream.readUTF();
            long fileLength = dataInputStream.readLong();

            file = new File(name);
            fileOutputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = dataInputStream.read(bytes, 0, bytes.length)) != -1) {
                fileOutputStream.write(bytes, 0, length);
                fileOutputStream.flush();
            }
            return true;

        } catch (IOException e) {
            System.out.println("error in ConfigReceive" + e);
            return false;
        }
    }

    public static void main(String[] args) {
        new ConfigReceive().VersionReceive();

    }
}
