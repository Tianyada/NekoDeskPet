import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Framework extends JFrame {
    private boolean isDragging = false;
    private Walker walker;

    public Framework() {
        setTitle("GIF Click Walker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setAlwaysOnTop(true);

        // 이미지 설정
        ImageIcon gifIcon = new ImageIcon("img/nekogif.gif"); // 원하는 GIF
        JLabel label = new JLabel(gifIcon);
        add(label);

        setSize(gifIcon.getIconWidth(), gifIcon.getIconHeight());
        setLocation(0, 0);
        setVisible(true);

        // ESC 키로 종료
        getRootPane().registerKeyboardAction(
                e -> System.exit(0),
                KeyStroke.getKeyStroke("ESCAPE"),
                JComponent.WHEN_IN_FOCUSED_WINDOW
        );

        // 드래그 처리
        MouseAdapter drag = new MouseAdapter() {
            Point offset;

            @Override
            public void mousePressed(MouseEvent e) {
                offset = e.getPoint();
                isDragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDragging = false;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point screen = e.getLocationOnScreen();
                setLocation(screen.x - offset.x, screen.y - offset.y);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isDragging && walker != null) {
                    // 클릭한 화면상의 위치
                    Point screen = e.getLocationOnScreen();
                }
            }
        };

        label.addMouseListener(drag);
        label.addMouseMotionListener(drag);

        // 걷는 기능 클래스 연결
        walker = new Walker(this);

    }
}

