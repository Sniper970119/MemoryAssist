package View;

import Control.ClosePro;
import Control.SetToArray;
import Data.*;
import Control.TimeControl;
import Data.DataBuffer;
import Handle.HandleConfig.ReadConfig;
import Handle.HandleData.DataScreen;
import Handle.HandleData.InitData;
import Handle.HandleData.SaveData;
import OtherTools.ButtonEditor;
import OtherTools.TableButton;
import oracle.jrockit.jfr.JFR;
import sun.applet.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Sniper on 2018/4/16.
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screensize.getWidth();
        int height = (int) screensize.getHeight();
        this.setBounds(width / 2 - 250, height / 2 - 250, 500, 500);
        this.setTitle("MemoryAssist 1.0");
//        this.setLocationRelativeTo(null);
        this.addWindowListener(new ClosePro()); //程序关闭前的资源保存与整理
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);

        JLabel time = new JLabel();
        this.add(time);
        time.setFont(new java.awt.Font("Dialog", 1, 30));
        time.setForeground(Color.red);
        time.setBounds(10, 10, 500, 40);
        new Thread(new TimeControl(this, time)).start();

        DataBuffer dataBuffer = DataBuffer.getDataBuffer();
        HashSet<Data> allData = dataBuffer.getScreenData();
//        ArrayList[] data = null;
        Object[][] data = new SetToArray().SetToArray(allData);


        JPanel panel = new JPanel();
        panel.setBounds(5, 40, 500, 200);
        this.getContentPane().add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(5, 40, 470, 170);
        panel.add(scrollPane);

        JTable table = new JTable();
        scrollPane.setViewportView(table);

        String columns[] = { "任务id", "主名称", "副名称","状态"," " };

        table.setModel(new DefaultTableModel(columns,7) {
            @Override
            public void setColumnIdentifiers(Object[] newIdentifiers) {
                super.setColumnIdentifiers(newIdentifiers);
            }

            @Override
            public Object getValueAt(int row, int column) {
                return data[row][column];

            }

            @Override
            public int getRowCount() {
                return allData.size();
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public void setValueAt(Object aValue, int row, int column) {
                data[row][column] = aValue;
                fireTableCellUpdated(row, column);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 4) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);

        table.getColumnModel().getColumn(4).setCellEditor(
                new ButtonEditor());

        table.getColumnModel().getColumn(4).setCellRenderer(
                new TableButton());

        table.setRowSelectionAllowed(false);

        JButton addMission = new JButton("添加");
        this.add(addMission);
        addMission.setBounds(50,400,80,30);
        addMission.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFrame();
            }
        });

        JButton queryAll = new JButton("全部");
        this.add(queryAll);
        queryAll.setBounds(160,400,80,30);
        queryAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QueryFrame();
            }
        });

        JButton edit = new JButton("编辑");
        this.add(edit);
        edit.setBounds(270,400,80,30);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditFrame();
            }
        });

        JButton flush = new JButton("刷新");
        this.add(flush);
        JFrame temp = this;
        flush.setBounds(370,400,80,30);
        flush.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temp.dispose();
                new SaveData();
                new InitData();
                new DataScreen();
                //替换部分
                new MainFrame();
            }
        });

    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
