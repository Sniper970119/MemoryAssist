package Control;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import Data.*;
import Handle.HandleData.InitData;
import Handle.HandleData.SaveData;
import sun.reflect.generics.tree.Tree;

/**
 * Created by Sniper on 2018/4/17.
 */
public class AllMission {
    public HashSet<Data> All(){
        new SaveData();
        new InitData();
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        HashSet<Data> hashSet = dataBuffer.getAllData();
        TreeSet<Data> treeSet = new TreeSet<Data>();        //使用hashSet进行重新排序
        Iterator<Data> iterator1 = hashSet.iterator();
        while (iterator1.hasNext()){
            Data temp = iterator1.next();
//            System.out.println("tree:"+temp);
            treeSet.add(temp);
        }
        Iterator<Data> iterator2 = treeSet.iterator();

//        for (Data a : hashSet) {
//            System.out.println("0set:"+a);
//        }
//        for (Data a : treeSet) {
//            System.out.println("0tree:"+a);
//        }
        hashSet.clear();
        while (iterator2.hasNext()){
            Data temp = iterator2.next();
//            System.out.println("set:"+temp);
            hashSet.add(temp);
        }
//        for (Data a : hashSet) {
//            System.out.println("1hash:"+a);
//        }
        return hashSet;
    }
    public static void main(String[] args){
        new InitData();
        new AllMission().All();
    }
}
