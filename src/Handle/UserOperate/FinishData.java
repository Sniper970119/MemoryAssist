package Handle.UserOperate;

import Data.*;
import Handle.HandleData.InitData;
import Handle.HandleData.SaveData;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Sniper on 2018/4/17.
 */
public class FinishData {
    public Data FinishData(Data data){
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        HashSet<Data> allData = dataBuffer.getAllData();
        HashSet<Data> screenData = dataBuffer.getScreenData();
        int state = data.getState();
        LocalDate localDate = data.getNextTime();
        if (state==0||state==7){      //不再出现或者状态等级最高
        }else {
            state++;
        }
        data.setFinish(true);   //更新完成状态
        data.setState(state);

        System.out.println("switch");

        switch (state){         //更新下次的时间
            case 0:localDate = localDate.plusDays(666666);break;
            case 2:System.out.println("case 2");localDate = localDate.plusDays(1);break;
            case 3:localDate = localDate.plusDays(2);break;
            case 4:localDate = localDate.plusDays(4);break;
            case 5:localDate = localDate.plusDays(7);break;
            case 6:localDate = localDate.plusDays(15);break;
            case 7:localDate = localDate.plusDays(15);break;
        }
        System.out.println("break");
        data.setNextTime(localDate);
        return data;
    }
    public static void main(String[] args){
        new InitData();
        Data data = new Data("001","a","b",LocalDate.now(),2);
        data = new FinishData().FinishData(data);
        new EditData(data);
//        System.out.println(data);
        new SaveData();
    }
}
