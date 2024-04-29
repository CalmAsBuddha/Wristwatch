import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalWatch extends TimerTask {

    private JFrame frame;
    private JLabel timeLabel;

    public DigitalWatch() {
        frame = new JFrame("Digital Watch");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        frame.add(timeLabel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        DigitalWatch digitalWatch = new DigitalWatch();
        timer.scheduleAtFixedRate(digitalWatch, 0, 1000);
    }
}
