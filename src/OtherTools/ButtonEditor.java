package OtherTools;

import Control.FinishMission;
import Data.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class ButtonEditor extends AbstractCellEditor implements
        TableCellEditor {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6546334664166791132L;

    private JPanel panel;

    private JButton button;

    private String num;

    public ButtonEditor() {

        initButton();

        initPanel();

        panel.add(this.button, BorderLayout.CENTER);
    }

    private void initButton() {
        button = new JButton();

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,
                        "确认完成?", "完成",
                        JOptionPane.YES_NO_OPTION);

                System.out.println(num);
                new FinishMission(new Data(num));
//                if(res ==  JOptionPane.YES_OPTION){
//                    num++;
//                }
                //stopped!!!!
                fireEditingStopped();

            }
        });

    }

    private void initPanel() {
        panel = new JPanel();

        panel.setLayout(new BorderLayout());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        num = (String) value;

        button.setText("确认");

        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return num;
    }

}