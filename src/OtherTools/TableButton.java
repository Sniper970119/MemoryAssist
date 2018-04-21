package OtherTools;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableButton implements TableCellRenderer {
    private JPanel panel;

    private JButton button;

    private String num;

    public TableButton() {
        initButton();

        initPanel();

        panel.add(button, BorderLayout.CENTER);
    }

    private void initButton() {
        button = new JButton();

    }

    private void initPanel() {
        panel = new JPanel();

        panel.setLayout(new BorderLayout());
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        num =  (String)value;

        button.setText("完成");

        return panel;
    }

}