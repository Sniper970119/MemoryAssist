package View;

import Control.AllMission;
import Control.SetToArray;
import Control.StartPro;
import Data.DataBuffer;
import Data.*;
import Handle.HandleData.InitData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashSet;

/**
 * Created by Sniper on 2018/4/16.
 */
public class QueryFrame extends JFrame {
    public QueryFrame() {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        this.setBounds(width / 2 - 150, height / 2 - 100, 510, 300);
        this.setLocationRelativeTo(null);
        this.setTitle("查询");
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);

        HashSet<Data> hashSet = new AllMission().All();

        JPanel panel = new JPanel();
        panel.setBounds(5, 10, 500, 200);
        this.getContentPane().add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 10, 470, 170);
        panel.add(scrollPane);

        Object[][] data = new SetToArray().SetToArray1(hashSet);
        String columns[] = {"任务id", "主名称", "副名称", "状态","当前完成情况","下次复习时间"};
        JTable jTable = new JTable(data,columns);

//        this.add(new JScrollPane(jTable));
        scrollPane.setViewportView(jTable);
        jTable.setModel(new DefaultTableModel(data,columns){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(100);

    }
    public static void main(String[] args){
        new InitData();
        new QueryFrame();
    }
}
