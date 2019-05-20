package Control;

import Data.Config;
import Handle.HandleCPUNumber.GetNumber;
import Handle.HandleCPUNumber.SendNumber;
import Handle.HandleConfig.ReadConfig;
import Handle.HandleConfig.SaveConfig;
import Handle.HandleData.DataScreen;
import Handle.HandleData.InitData;
import Handle.HandleData.SaveData;
import Handle.UserMessage.UserMessage;
import Handle.VersionControl.ConfigReceive;
import Handle.VersionControl.ConfirmVersion;
import Handle.VersionControl.MessageReceive;
import Handle.VersionControl.VersionReceive;
import View.HintFrame;
import View.MainFrame;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sniper on 2018/4/17.
 */
public class StartPro {//
    Map map = new HashMap();

    public StartPro() {
        new ReadConfig();
        new InitData();
        new DataScreen();
        new FileDelete();

        Config config = Config.getConfig();
        String id = config.getId();
        System.out.println("01.id:" + id);
        String version = config.getVersion();
        String upDate = config.getUpdate();

        if (new ConfirmVersion().ConfirmVersion(version)) {      // 对版本进行控制
            new MainFrame();
        } else {     //获取新版本
            new VersionReceive().VersionReceive();
            new ConfigReceive().VersionReceive();
            config.setId(id);
            new ReadConfig();
            config = Config.getConfig();
            version = config.getVersion();
            upDate = config.getUpdate();
            System.out.println("version:" + version);
            new HintFrame("<br> <br/><br> <br/><br> <br/>更新中。。。。");
            map.put("id", id);
            map.put("update", "true");
            map.put("version", version);
            //
            new SaveConfig(map);

            try {
                Thread.sleep(1500);
                JOptionPane.showMessageDialog(new JFrame().getContentPane(),
                        "更新完成\n请重启程序", "成功", JOptionPane.INFORMATION_MESSAGE);
                Thread.sleep(200);
                System.exit(0);
            } catch (InterruptedException e) {
                System.out.println("Error in StartPro Sleep:" + e);
            }
        }
        String code = new GetNumber().GetNumber();  //获取CPU序列号
        String message = new UserMessage().UserMessage();

        if (!new SendNumber().Judge( message + "\tCPUNumber:" + code)) {//新用户
            new HintFrame("<br>说明<br/>德国心理学家艾宾浩斯(H.Ebbinghaus）研究发现，遗忘在学习之后立即开始，" +
                    "而且遗忘的进程并不是均匀的。最初遗忘速度很快，以后逐渐缓慢。他认为\"保" +
                    "持和遗忘是时间的函数\"，他用无意义音节（由若干音节字母组成、能够读出、" +
                    "但无内容意义即不是词的音节）作记忆材料，用节省法计算保持和遗忘的数量。" +
                    " 并根据他的实验结果绘成描述遗忘进程的曲线，即著名的艾宾浩斯记忆遗忘曲线。<br>" +
                    "本软件就是根据艾宾浩斯记忆遗忘曲线动态分配学习&复习计划，用户只需要将任务分成若干" +
                    "小任务，每天在软件中添加小任务，完成后点击完成，根据提示完成当天的学习任务即可。");
        }
        if (upDate.equals("true")) {     //刚更新完  提示更新说明
            new HintFrame("<br>更新说明<br>" +
                    "1.修复已知bug<br/>");
        }


//        String code = new GetNumber().GetNumber();  //获取CPU序列号
//        String message = new UserMessage().UserMessage();
//        new SendNumber().Judge(message+"\tCPU序列号:"+code);       //向服务器发送序列号


//替换部分
//            System.out.println("in");
//
    }

    public static void main(String[] args) {
        new StartPro();
    }
}
