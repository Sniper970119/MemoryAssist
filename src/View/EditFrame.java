package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import Control.EditMission;
import Control.QueryMission;
import Data.*;
import Handle.HandleData.InitData;
import Handle.UserOperate.RemoveData;

/**
 * Created by Sniper on 2018/4/16.
 */
public class EditFrame extends JFrame {
    LocalDate temp = null;
    public EditFrame() {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        this.setBounds(width / 2 - 150, height / 2 - 100, 600, 300);
        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);

        JLabel jLabelID = new JLabel("任务id:");
        JLabel jLabelmainName = new JLabel("主名字:");
        JLabel jLabelindexName = new JLabel("副名字:");
        JLabel jLabelNextTime = new JLabel("下次复习时间:");
        JLabel jLabelState = new JLabel("状态:");
        JLabel jLabelHint = new JLabel("输入数字  " +
                "0:不再复习  1：当日复习  2：次日复习  3：两天后复习  4：四天后复习");
        JLabel jLabelHint1 = new JLabel("5:七天后复习  6：十五天后复习  7：巩固状态（每15天）");

        JTextField jTextFieldID = new JTextField();
        JTextField jTextFieldMainName = new JTextField();
        JTextField jTextFieldIndexName = new JTextField();
        JTextField jTextFieldState = new JTextField();

        this.add(jLabelID);
        this.add(jLabelmainName);
        this.add(jLabelindexName);
        this.add(jLabelNextTime);
        this.add(jLabelState);
        this.add(jLabelHint);
        this.add(jLabelHint1);
        this.add(jTextFieldID);
        this.add(jTextFieldMainName);
        this.add(jTextFieldIndexName);
        this.add(jTextFieldState);

        jLabelID.setBounds(10,10,50,30);
        jLabelmainName.setBounds(10,50,50,30);
        jLabelindexName.setBounds(170,50,50,30);
        jLabelNextTime.setBounds(10,90,200,30);
        jLabelState.setBounds(10,130,50,30);
        jLabelHint.setBounds(10,160,500,30);
        jLabelHint1.setBounds(10,175,500,30);
        jTextFieldID.setBounds(60,10,100,30);
        jTextFieldMainName.setBounds(60,50,100,30);
        jTextFieldIndexName.setBounds(230,50,100,30);
        jTextFieldState.setBounds(60,130,50,30);

        JButton save = new JButton("保存");
        JButton remove = new JButton("删除");

        this.add(save);
        this.add(remove);

        save.setBounds(50,210,100,30);
        remove.setBounds(300,210,100,30);

        jTextFieldMainName.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String id = jTextFieldID.getText().trim();
                Data data = new QueryMission().Query(id);
                System.out.println(data);
                temp = data.getNextTime();
                jTextFieldMainName.setText(data.getMainName());
                jTextFieldIndexName.setText(data.getIndexName());
                jLabelNextTime.setText("下次复习时间: "+data.getNextTime());
                jTextFieldState.setText(""+data.getState());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = jTextFieldID.getText();
                String main = jTextFieldMainName.getText();
                String index = jTextFieldIndexName.getText();
                int state = Integer.parseInt(jTextFieldState.getText());
                Data data1 = new Data(id,main,index,temp,state);
                new EditMission(data1);
                JOptionPane.showMessageDialog(new JFrame().getContentPane(),
                        "修改成功", "成功", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = jTextFieldID.getText();
                new RemoveData(new Data(id));
                jTextFieldID.setText("");
                jTextFieldMainName.setText("");
                jTextFieldIndexName.setText("");
                jTextFieldState.setText("");
                jLabelNextTime.setText("下次复习时间:");
                JOptionPane.showMessageDialog(new JFrame().getContentPane(),
                        "删除成功", "成功", JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }
    public static void main(String[] args){
        new InitData();
        new EditFrame();
    }
}
