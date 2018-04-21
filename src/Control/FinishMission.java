package Control;

import Data.*;
import Handle.HandleData.InitData;
import Handle.HandleData.SaveData;
import Handle.UserOperate.EditData;
import Handle.UserOperate.FinishData;

import javax.swing.text.html.HTMLDocument;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Sniper on 2018/4/17.
 */
public class FinishMission {
    public FinishMission(Data data){
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        HashSet<Data> screenSet = dataBuffer.getScreenData();
        Iterator<Data> iterator = screenSet.iterator();
        while(iterator.hasNext()){
            Data temp = iterator.next();
            if (temp.equals(data)){
//                System.out.println("in"+temp);
                data = temp;
                break;
            }
        }
//        System.out.println(data.toString());
        data = new FinishData().FinishData(data);
        new EditData(data);
//        new SaveData();
//        new InitData();
    }
    public static void main(String[] args){
        new StartPro();
        Data data = new Data("001","a","b", LocalDate.now());
        new FinishMission(data);
        new ClosePro();
    }
}
