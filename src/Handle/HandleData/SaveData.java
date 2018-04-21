package Handle.HandleData;

import Data.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Sniper on 2018/4/16.
 */
public class SaveData {
    public SaveData() {
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("Data.xml"));
        } catch (IOException e) {
            System.out.println("FileNotFound in SaveData:"+e);
        }
        HashSet<Data> allData = dataBuffer.getAllData();
        HashSet<Data> screenData = dataBuffer.getScreenData();

        screenData.addAll(allData);

        Iterator iterator = screenData.iterator();

        while(iterator.hasNext()){
            Data data = (Data) iterator.next();
            try {
                objectOutputStream.writeObject(data);
            } catch (IOException e) {
                System.out.println("Can not write object in SaveData:"+e);
            }
//            System.out.println(data);
        }
    }
    public static void main(String[] args) throws Exception {
        HashSet allData = new HashSet();
        HashSet screenData = new HashSet();
        allData.add(new Data("001","a","b",LocalDate.now(),1));
        allData.add(new Data("002","b","b",LocalDate.now(),1));
        allData.add(new Data("003","c","b",LocalDate.now(),1));
        LocalDate localDate = LocalDate.of(2019,2,2);
        screenData.add(new Data("002","b","bbbbb",localDate,1));
//        screenData.add(new Data("004","d","bbbbb",new Date(),1));

        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        dataBuffer.setAllData(allData);
        dataBuffer.setScreenData(screenData);
        new SaveData();

    }
}
