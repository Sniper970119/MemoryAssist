package Handle.HandleData;

import Data.Data;
import Data.DataBuffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Sniper on 2018/4/16.
 */
public class InitData {
    public InitData() {
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        HashSet<Data> allData = new HashSet<Data>();
        HashSet<Data> screenData = new HashSet<Data>();
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("Data.xml"));
        } catch (IOException e) {
            System.out.println("FileNotFound In InitData:" + e);
        }

        Data data = null;
        try {
            while ((data = (Data) objectInputStream.readObject()) != null) {
                allData.add(data);
            }
        } catch (IOException e) {
//            System.out.println("IOException in InitData:" + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException in InitData:" + e);
        } finally {
            dataBuffer.setAllData(allData);
            try {
                objectInputStream.close();
            } catch (IOException e) {
                System.out.println("StreamCloseError in InitData:" + e);
            }
        }

        //测试输出
        Iterator iterator = allData.iterator();
        while(iterator.hasNext()){
            System.out.println("init:"+iterator.next());
        }
    }

    public static void main(String[] args) {
        new InitData();
    }
}
