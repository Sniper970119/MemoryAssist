package Handle.HandleData;

import Data.Data;
import Data.DataBuffer;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Sniper on 2018/4/16.
 */
public class DataScreen {
    public DataScreen() {
        LocalDate nowTime = LocalDate.now();
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        HashSet<Data> allData = dataBuffer.getAllData();
        HashSet<Data> screenData = new HashSet<Data>();

        Iterator<Data> iterator = allData.iterator();
        while (iterator.hasNext()) {
            Data data = iterator.next();
            if (data.isFinish()==false&&(data.getNextTime().isBefore(nowTime)||data.getNextTime().isEqual(nowTime))) {
                data.setFinish(false);
                screenData.add(data);
                System.out.println("screen:"+data);
            }
        }
        dataBuffer.setScreenData(screenData);
    }

    public static void main(String[] args) {
        new InitData();
        new DataScreen();
    }
}
