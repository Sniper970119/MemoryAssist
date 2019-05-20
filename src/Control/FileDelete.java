package Control;

import java.io.File;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Sniper on 2018/4/20.
 */
public class FileDelete {
    FileDelete(){
        String nowPath = System.getProperty("user.dir");
//        System.out.println(file.getAbsolutePath());
//        String path = file.getAbsolutePath();
//        int index = path.lastIndexOf("\\");
//        String nowPath = new String(path.getBytes(),0,index);
        System.out.println(nowPath);
        File file1 = new File(nowPath);
        String[] filelist = file1.list();
        ArrayList<File> arrayList = new ArrayList<>();
        for (String s : filelist) {
            File temp = new File(s);
            Date date = new Date(temp.lastModified());
            if (s.endsWith(".jar")){
                arrayList.add(temp);
            }
            System.out.println(date.toString());
        }
        File temp = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            Date date = new Date(temp.lastModified());
           if (new Date(arrayList.get(i).lastModified()).after(date)){
               temp = arrayList.get(i);
           }
        }
        arrayList.remove(temp);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).delete();
//            System.out.println(arrayList.get(i));
        }
    }
    public static void main(String[] args){

//System.out.println(curDir);
        new FileDelete();
//        new FileDelete(new File("F:\\JAVA\\pro\\MemoryAssist\\MemoryAssist(Beta 2)"));
    }
}
