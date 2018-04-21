package Handle.UserOperate;

import Data.*;
import Handle.HandleData.InitData;
import Handle.HandleData.SaveData;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Sniper on 2018/4/17.
 */
public class RemoveData {
    public RemoveData(Data data){
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        HashSet<Data> allData = dataBuffer.getAllData();
        HashSet<Data> screenData = dataBuffer.getScreenData();

        if (screenData.contains(data)){
            screenData.remove(data);
        }
        if (allData.contains(data)){
            allData.remove(data);
        }
        //测试输出
//        Iterator<Data> temp = screenData.iterator();
//        while(temp.hasNext()){
//            System.out.println("screen:"+temp.next());
//        }
//        Iterator<Data> temp1 = allData.iterator();
//        while(temp1.hasNext()){
//            System.out.println("all:"+temp1.next());
//        }

        dataBuffer.setScreenData(screenData);
        dataBuffer.setAllData(allData);
    }
    public static void main(String[] args){
        new InitData();
        Data data = new Data("002","b","bbbbb", LocalDate.now(),2);
        new RemoveData(data);
        new SaveData();
        new InitData();
    }
}
