import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 창 띄우기
            new Framework();

            // 이미지 경로 확인
            String relativePath = "img/nekogif.gif";
            File imageFile = new File(relativePath);

            if (imageFile.exists()) {
                System.out.println("상대 경로 이미지 파일 발견: " + imageFile.getAbsolutePath());
            } else {
                System.out.println("상대 경로 이미지 파일 없음");
            }

            // 현재 작업 디렉토리 확인
            String userDir = System.getProperty("user.dir");
            System.out.println("현재 작업 디렉토리: " + userDir);
        });
    }
}
