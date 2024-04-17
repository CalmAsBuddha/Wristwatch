import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.TimerTask;

public class Wristwatch extends TimerTask {

    private Frame frame;
    private Canvas watchCanvas;
    private Label timeLabel;
    private int hours, minutes, seconds;

    public Wristwatch() {
        frame = new Frame("Digital Wristwatch");
        watchCanvas = new Canvas();
        watchCanvas.setSize(200, 200);
        watchCanvas.setBackground(Color.WHITE);
        watchCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("Left click detected");
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    System.out.println("Middle click detected");
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Right click detected");
                }
            }
        });
        timeLabel = new Label();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(watchCanvas, BorderLayout.CENTER);
        frame.add(timeLabel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        hours = calendar.get(Calendar.HOUR_OF_DAY);
        minutes = calendar.get(Calendar.MINUTE);
        seconds = calendar.get(Calendar.SECOND);
        repaint();
    }

    private void repaint() {

    }

    public void paint(Graphics g) throws InterruptedException {
        super.wait();

        // Draw the watch face
        g.setColor(Color.BLACK);
        g.fillOval(0, 0, 200, 200);

        // Draw the hour markers
        for (int i = 0; i < 12; i++) {
            int angle = (int) (i * 30 * Math.PI / 180);
            int x1 = (int) (100 + 80 * Math.cos(angle));
            int y1 = (int) (100 + 80 * Math.sin(angle));
            int x2 = (int) (100 + 60 * Math.cos(angle));
            int y2 = (int) (100 + 60 * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }

        // Draw the minute markers
        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) {
                continue;
            }

            int angle = (int) (i * 6 * Math.PI / 180);
            int x1 = (int) (100 + 70 * Math.cos(angle));
            int y1 = (int) (100 + 70 * Math.sin(angle));
            int x2 = (int) (100 + 50 * Math.cos(angle));
            int y2 = (int) (100 + 50 * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }

        // Draw the hour, minute, and second hands
        int hourAngle = (int) ((hours + minutes / 60.0) * 30 * Math.PI / 180);
        int minuteAngle = (int) (minutes * 6 * Math.PI / 180);
        int secondAngle = (int) (seconds * 6 * Math.PI / 180);

        g.setColor(Color.RED);
        int handLength = 70;
        int xHand = (int) (100 + handLength * Math.cos(hourAngle));
        int yHand = (int) (100 + handLength * Math.sin(hourAngle));
    }
}

