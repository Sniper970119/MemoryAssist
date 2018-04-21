package Handle.UserOperate;

import Data.*;
import Handle.HandleData.DataScreen;
import Handle.HandleData.InitData;
import Handle.HandleData.SaveData;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Sniper on 2018/4/17.
 */
public class EditData {
    public EditData(Data data){
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        HashSet<Data> allData = dataBuffer.getAllData();
        HashSet<Data> screenData = dataBuffer.getScreenData();
        boolean isInScreen = false;

        if (screenData.contains(data)){
//            System.out.println("screen");
            screenData.remove(data);
            screenData.add(data);
            isInScreen = true;
            /**
             *
             * 因为动态页面的问题。这里还不能加这个判断
             * */
//            if (data.isFinish()){
//                screenData.remove(data);
//                allData.remove(data);
//                allData.add(data);
//            }

        }
        if (!isInScreen){
//            System.out.println("all");
            allData.remove(data);
            allData.add(data);
        }
        //测试输出
        Iterator<Data> temp = screenData.iterator();
        while(temp.hasNext()){
            System.out.println("screen:"+temp.next());
        }
        for (Data d: allData) {
            System.out.println("all"+d);
        }
        dataBuffer.setScreenData(screenData);
        dataBuffer.setAllData(allData);
    }
    public static void main(String[] args){
        new InitData();
        new DataScreen();
        Data data = new Data("001","aa","bb", LocalDate.now(),1);
        new EditData(data);
        try {
            new SaveData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        new InitData();
    }
}
