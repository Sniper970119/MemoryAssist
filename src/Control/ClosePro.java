package Control;

import Data.Config;
import Handle.HandleConfig.ReadConfig;
import Handle.HandleConfig.SaveConfig;
import Handle.HandleData.DataScreen;
import Handle.HandleData.InitData;
import Handle.HandleData.SaveData;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sniper on 2018/4/17.
 */
public class ClosePro extends WindowAdapter {
    public ClosePro() {
//        new SaveData();
//        Config config = Config.getConfig();
//        Map map = new HashMap();
//        // 可替换部分
//        map.put("id","00"+config.getId());
//        //
//        new SaveConfig(map);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        new SaveData();
        Config config = Config.getConfig();
        Map map = new HashMap();
        // 可替换部分
        map.put("id",config.getId());
        map.put("update","false");
        map.put("version",config.getVersion());
        //
        new SaveConfig(map);
        System.out.println("window is closed !");
    }

    public static void main(String[] args) {
        new ReadConfig();
        new InitData();
        new DataScreen();
        new ClosePro();
    }
}
