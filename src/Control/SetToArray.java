package Control;

import Data.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Sniper on 2018/4/17.
 */
public class SetToArray {
    public Object[][] SetToArray(HashSet hashSet){
//        System.out.println(hashSet.size());
        int a = hashSet.size();
        Object[][] data = new Object[hashSet.size()][7];
        Iterator<Data> iterator = hashSet.iterator();
        for (int i = 0; i < 8; i++) {
            if (iterator.hasNext()){
                Data data1 = iterator.next();
                data[i][0] = data1.getId();
                data[i][4] = data1.getId();
                data[i][1] = data1.getMainName();
                data[i][2] = data1.getIndexName();
                data[i][6] = data1.getNextTime();
                int state = data1.getState();
                switch (state){
                    case 1:data[i][3] = "当日";break;
                    case 2:data[i][3] = "次日";break;
                    case 3:data[i][3] = "两天后";break;
                    case 4:data[i][3] = "四天后";break;
                    case 5:data[i][3] = "七天后";break;
                    case 6:data[i][3] = "十五天后";break;
                    case 7:data[i][3] = "更多";break;
                    case 0:data[i][3] = "不再提醒";break;
                }
                if (data1.isFinish()){
                    data[i][5]= "完成";
                }else{
                    data[i][5]= "未完成";

                }
            }
        }

//        System.out.println("?");
        for (int i = 0; i < hashSet.size(); i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }

        return data;
    }
    public Object[][] SetToArray1(HashSet hashSet){
//        System.out.println(hashSet.size());
        int a = hashSet.size();
        Object[][] data = new Object[hashSet.size()][6];
        Iterator<Data> iterator = hashSet.iterator();
        for (int i = 0; i < 8; i++) {
            if (iterator.hasNext()){
                Data data1 = iterator.next();
                data[i][0] = data1.getId();
                data[i][1] = data1.getMainName();
                data[i][2] = data1.getIndexName();
                data[i][5] = data1.getNextTime();
                int state = data1.getState();
                switch (state){
                    case 1:data[i][3] = "当日";break;
                    case 2:data[i][3] = "次日";break;
                    case 3:data[i][3] = "两天后";break;
                    case 4:data[i][3] = "四天后";break;
                    case 5:data[i][3] = "七天后";break;
                    case 6:data[i][3] = "十五天后";break;
                    case 7:data[i][3] = "更多";break;
                    case 0:data[i][3] = "不再提醒";break;
                }
                if (data1.isFinish()){
                    data[i][4]= "完成";
                }else{
                    data[i][4]= "未完成";

                }
            }
        }

//        System.out.println("?");
        for (int i = 0; i < hashSet.size(); i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }

        return data;
    }
    public static void main(String[] args){
        HashSet allData = new HashSet();
        allData.add(new Data("001","a","b", LocalDate.now()));
        allData.add(new Data("002","b","b",LocalDate.now()));
        allData.add(new Data("003","c","b",LocalDate.now()));
        new SetToArray().SetToArray(allData);
    }
}
