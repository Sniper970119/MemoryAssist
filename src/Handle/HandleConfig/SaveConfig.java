package Handle.HandleConfig;

import java.io.*;
import java.util.*;

/**
 * Created by Sniper on 2018/4/16.
 */
public class SaveConfig {
    public SaveConfig(Map map){
        Properties properties = new Properties();
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("Config.conf");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound in SaveConfig:"+e);
        }

        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();

        while(iterator.hasNext()){
            String key = (String)iterator.next();
            String value = (String)map.get(key);
            properties.put(key,value);
//            System.out.println(key+" "+value);
        }
        try {
            properties.store(outputStream,"Config file");
        } catch (IOException e) {
            System.out.println("save error in SaveConfig:"+e);
        }
    }
    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        map.put("color","yellow");
        map.put("debug","false");
        map.put("id","1");
        new SaveConfig(map);
    }
}
