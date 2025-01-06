package app.standard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Util {

    public static class File {
        public static void test() {
            System.out.println("파일 유틸 테스트");
        }

        public static void createFile(String pathValue) {
            Path filepath = Paths.get(pathValue);
            
//            if (Files.exists(filepath)) {
//                return;
//            }
            try {
                Files.createFile(filepath);
            } catch (Exception e) {
                System.out.println("파일 생성 중 실패");
                e.printStackTrace();
            }

        }

        public static String readAsString(String file) {
            Path filepath = Paths.get(file);

            try {
                return Files.readString(filepath);
            } catch (IOException e) {
                System.out.println("파일 읽기 실패");
                e.printStackTrace();
            }

            return "";
        }

        public static void write(String file, String content) {
            Path filepath = Paths.get(file);

            try {
                Files.writeString(filepath, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                System.out.println("파일 쓰기 실패");
                e.printStackTrace();
            }

        }
    }

}
