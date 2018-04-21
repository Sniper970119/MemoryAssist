package View;

import Control.AddMission;
import Data.Data;
import Handle.HandleConfig.ReadConfig;
import Handle.HandleData.DataScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Created by Sniper on 2018/4/16.
 */
public class AddFrame extends JFrame {
    public AddFrame(){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        this.setBounds(width / 2 - 150, height / 2 - 100, 350, 300);
        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("增加");


        JLabel mainName = new JLabel("主名字");
        JLabel indexName = new JLabel("副名字");
        JTextField main = new JTextField();
        JTextField index = new JTextField();
        JButton add = new JButton("添加");

        this.add(mainName);
        this.add(indexName);
        this.add(main);
        this.add(index);
        this.add(add);

        mainName.setBounds(20,40,80,30);
        indexName.setBounds(20,110,80,30);
        main.setBounds(80,40,200,30);
        index.setBounds(80,110,200,30);
        add.setBounds(120,180,100,30);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mainString = main.getText();
                String indexString = index.getText();
                System.out.println(indexString.trim().length());
                if (mainString.trim().length()==0||indexString.trim().length()==0){
                    JOptionPane.showMessageDialog(new JFrame().getContentPane(),
                            "不允许出现空字段", "系统信息", JOptionPane.WARNING_MESSAGE);
                }else {
                    new AddMission(new Data("000",mainString,indexString, LocalDate.now()));
                    main.setText("");
                    index.setText("");
                    JOptionPane.showMessageDialog(new JFrame().getContentPane(),
                            "添加成功", "成功", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });



    }
    public static void main(String[] args){
        new ReadConfig();
        new AddFrame();
    }
}
