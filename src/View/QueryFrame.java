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
        this.setBounds(width / 2 - 150, height / 2 - 100, 410, 300);
        this.setLocationRelativeTo(null);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);

        HashSet<Data> hashSet = new AllMission().All();

        JPanel panel = new JPanel();
        panel.setBounds(5, 10, 400, 200);
        this.getContentPane().add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 10, 370, 170);
        panel.add(scrollPane);

        Object[][] data = new SetToArray().SetToArray(hashSet);
        String columns[] = {"任务id", "主名称", "副名称", "状态", "完成情况"};
        JTable jTable = new JTable(data,columns);
//        this.add(new JScrollPane(jTable));
        scrollPane.setViewportView(jTable);
        jTable.setModel(new DefaultTableModel(data,columns){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }
    public static void main(String[] args){
        new InitData();
        new QueryFrame();
    }
}
