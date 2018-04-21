package Control;

import java.util.HashSet;
import java.util.Iterator;

import Data.*;

/**
 * Created by Sniper on 2018/4/17.
 */
public class QueryMission {
    public Data Query(String id) {
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        HashSet<Data> allData = dataBuffer.getAllData();
        HashSet<Data> screenData = dataBuffer.getScreenData();
        Data data = new Data(id);
        if (screenData.contains(data)) {
            System.out.println("screen");
            Iterator<Data> iterator = screenData.iterator();
            while (iterator.hasNext()) {
                Data temp = iterator.next();
                if (temp.equals(data)) {
                    return temp;
                }
            }
        } else {
            System.out.println("all");
            Iterator<Data> iterator = allData.iterator();
            while (iterator.hasNext()) {
                Data temp = iterator.next();
                if (data.equals(temp)) {
                    return temp;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        new StartPro();
        System.out.println(new QueryMission().Query("001"));
        new ClosePro();
    }
}
