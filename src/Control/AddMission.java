package Control;

import Data.*;
import Handle.HandleConfig.ReadConfig;
import Handle.HandleData.InitData;

import java.util.HashSet;

/**
 * Created by Sniper on 2018/4/17.
 */
public class AddMission {
    public AddMission(Data data) {
        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        Config config = Config.getConfig();
        HashSet<Data> hashSet = dataBuffer.getAllData();

        int idInt = Integer.parseInt(config.getId());
        idInt = idInt + 1;
        String idString = String.format("%03d",idInt);
        data.setId(idString);

        hashSet.add(data);
        dataBuffer.setAllData(hashSet);//写回缓存
        config.setId(idString); //写回配置文件
        System.out.println(idString);

    }
    public static void main(String[] args){
        new ReadConfig();
        new AddMission(new Data("001"));
    }
}
