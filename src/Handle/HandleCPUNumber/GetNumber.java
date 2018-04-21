package Handle.HandleCPUNumber;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/4/16.
 */
public class GetNumber {
    String serial = null;
    public String GetNumber() {
        try {
            Process process = Runtime.getRuntime().exec(
                    new String[]{"wmic", "cpu", "get", "ProcessorId"});
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            sc.next();
            serial = sc.next();
        } catch (IOException e) {
            System.out.println("Error in GetNumber:" + e);
        }
        return serial;
    }
    public static void main(String[] args){
        System.out.println(new GetNumber().GetNumber());
    }
}
