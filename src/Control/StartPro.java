package Control;

import Handle.HandleCPUNumber.GetNumber;
import Handle.HandleCPUNumber.SendNumber;
import Handle.HandleConfig.ReadConfig;
import Handle.HandleData.DataScreen;
import Handle.HandleData.InitData;
import Handle.HandleData.SaveData;
import View.MainFrame;

import javax.swing.*;

/**
 * Created by Sniper on 2018/4/17.
 */
public class StartPro {
    public StartPro(){
        String code = new GetNumber().GetNumber();
        if (new SendNumber().Judge(code)){
            new ReadConfig();
            new InitData();
            new DataScreen();
            //替换部分
            new MainFrame();
//            System.out.println("in");
            //
        }else {
            //替换部分
            JOptionPane.showMessageDialog(null, "请联系QQ 359366783 添加权限\n\r"+code, "没有权限", JOptionPane.ERROR_MESSAGE);
//            System.out.println("out");
            //
        }
    }
    public static void main(String[] args){
        new StartPro();
    }
}
