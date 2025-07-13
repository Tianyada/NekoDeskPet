import javax.swing.*;
import java.awt.*;

public class Walker {
    private final JFrame frame;
    private final Timer timer;

    public Walker(JFrame frame) {
        this.frame = frame;

        timer = new Timer(10, e -> update());
        timer.start();
    }

    private void update() {
        Point mousePos = MouseInfo.getPointerInfo().getLocation();
        Point framePos = frame.getLocation();

        // 목표 위치: 마우스보다 약간 떨어진 위치
        int targetX = mousePos.x - frame.getWidth() / 2;
        int targetY = mousePos.y - frame.getHeight() / 2;

        int dx = targetX - framePos.x;
        int dy = targetY - framePos.y;

        double distance = Math.sqrt(dx * dx + dy * dy);

        // 50픽셀 이상 떨어졌을 때만 이동
        if (distance > 50) {
            int newX = framePos.x + (int)(dx * 0.06);
            int newY = framePos.y + (int)(dy * 0.06);
            frame.setLocation(newX, newY);
        }
    }
}

