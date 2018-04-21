package Handle.HandleConfig;

import Data.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Sniper on 2018/4/16.
 */
public class ReadConfig {
    public ReadConfig() {
        Properties properties = new Properties();
        Config config = Config.getConfig();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("Config.conf");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound in ReadConfig:" + e);
        }

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("read Config error in ReadConfig:" + e);
        }

//        Set keyValue = properties.keySet();
//        Iterator it = keyValue.iterator();

//        String key = (String) it.next();
        String value = properties.getProperty("id");
        config.setId(value);
        String version = properties.getProperty("version");
        config.setVersion(version);
        config.setUpdate(properties.getProperty("update"));

//
//        while (it.hasNext()) {
//            String key = (String) it.next();
//            String value = properties.getProperty(key);
//            System.out.println(key + " " + value);
//        }
//        System.out.println(config.getId()+config.getVersion()+config.getUpdate());
    }

    public static void main(String[] args) throws Exception {
        new ReadConfig();
    }
}
