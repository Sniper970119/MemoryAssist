package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sniper on 2018/4/19.
 */
public class HintFrame extends JFrame {
    public HintFrame(String text) {
        this.setTitle("说明");
        JLabel label = new JLabel();
        label.setSize(400, 0);//注意JLabel一定要设置宽度
//      System.out.println(label.getWidth());
        this.setLocationRelativeTo(null);
        try {
            JlabelSetText(label, text);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setLayout(new FlowLayout());
        label.setFont(new Font("宋体", Font.BOLD, 14));
        add(label);
        pack();
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void JlabelSetText(JLabel jLabel, String longString)
            throws InterruptedException {
        StringBuilder builder = new StringBuilder("<html>");
        char[] chars = longString.toCharArray();
        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
        int start = 0;
        int len = 0;
        while (start + len < longString.length()) {
            while (true) {
                len++;
                if (start + len > longString.length()) break;
                if (fontMetrics.charsWidth(chars, start, len)
                        > jLabel.getWidth()) {
                    break;
                }
            }
            builder.append(chars, start, len - 1).append("<br/>");
            start = start + len - 1;
            len = 0;
        }
        builder.append(chars, start, longString.length() - start);
        builder.append("</html>");
        jLabel.setText(builder.toString());
    }

    public static void main(String[] args) {
//        new HintFrame("<br>说明<br/>德国心理学家艾宾浩斯(H.Ebbinghaus）研究发现，遗忘在学习之后立即开始，" +
//                "而且遗忘的进程并不是均匀的。最初遗忘速度很快，以后逐渐缓慢。他认为\"保" +
//                "持和遗忘是时间的函数\"，他用无意义音节（由若干音节字母组成、能够读出、" +
//                "但无内容意义即不是词的音节）作记忆材料，用节省法计算保持和遗忘的数量。" +
//                " 并根据他的实验结果绘成描述遗忘进程的曲线，即著名的艾宾浩斯记忆遗忘曲线。<br>" +
//                "本软件就是根据艾宾浩斯记忆遗忘曲线动态分配学习&复习计划，用户只需要将任务分成若干" +
//                "小任务，每天在软件中添加小任务，完成后点击完成，根据提示完成当天的学习任务即可。");
        new HintFrame("<br> <br/><br> <br/><br> <br/><br> <br/>更新中。。。。");

    }
}
