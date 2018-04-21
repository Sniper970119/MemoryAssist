package Data;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by Sniper on 2018/4/16.
 */
public class DataBuffer {
    private final static DataBuffer dataBuffer = new DataBuffer();
    HashSet<Data> allData = new HashSet<Data>();
    HashSet<Data> screenData = new HashSet<Data>();
    private DataBuffer(){
    }

    public static DataBuffer getDataBuffer() {
        return dataBuffer;
    }

    public HashSet<Data> getAllData() {
        return allData;
    }

    public void setAllData(HashSet<Data> allData) {
        this.allData = allData;
    }

    public HashSet<Data> getScreenData() {
        return screenData;
    }

    public void setScreenData(HashSet<Data> screenData) {
        this.screenData = screenData;
    }
}
