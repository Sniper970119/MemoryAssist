package Control;

import Data.Data;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.util.Date;

/**
 * Created by Sniper on 2018/4/17.
 */
public class TimeControl implements Runnable {
    JFrame jFrame = null;
    JLabel jLabel = null;

    public TimeControl(JFrame jFrame, JLabel jLabel) {
        this.jFrame = jFrame;
        this.jLabel = jLabel;
    }

    @Override
    public void run() {
//        System.out.println("in");
        while (true) {
            Date date = new Date();
            jLabel.setText(date.toString());
            jFrame.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleep error in TimeControl" + e);
            }
        }
    }
}
