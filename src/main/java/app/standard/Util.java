package app.standard;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.Map;

public class Util {

    public static class File {
        public static void test() {
            System.out.println("파일 유틸 테스트");
        }

        public static void createFile(String pathValue) {
            write(pathValue, "");
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

            if (filepath.getParent() != null) {
                createDir(filepath.getParent().toString());
            }

            try {
                Files.writeString(filepath, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                System.out.println("파일 쓰기 실패");
                e.printStackTrace();
            }
        }

        public static void delete(String file) {
            Path filepath = Paths.get(file);

            if (!Files.exists(filepath)) return;

            try {
                Files.delete(filepath);
            } catch (IOException e) {
                System.out.println("파일 삭제 실패");
                e.printStackTrace();
            }
        }

        public static void createDir(String dirPath) {
            try {
                Files.createDirectories(Paths.get(dirPath));
            } catch (IOException e) {
                System.out.println("디렉토리 생성 실패");
                e.printStackTrace();
            }
        }

        public static void deleteForce(String path) {

            Path folderPath = Paths.get(path);

            if (!Files.exists(folderPath)) return;

            try {
                // 디렉토리 및 내용 삭제
                Files.walkFileTree(folderPath, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        // 파일 삭제
                        Files.delete(file);
                        System.out.println("파일 삭제됨: " + file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        // 디렉토리 삭제 (내부 파일 모두 삭제 후 호출됨)
                        Files.delete(dir);
                        System.out.println("디렉토리 삭제됨: " + dir);
                        return FileVisitResult.CONTINUE;
                    }
                });

                System.out.println("폴더와 그 안의 내용이 성공적으로 삭제되었습니다.");
            } catch (IOException e) {
                System.err.println("폴더 삭제 중 오류 발생: " + e.getMessage());
            }
        }
    }

    public static class Json {
        public static String mapToJson(Map<String, Object> map) {

            StringBuilder jsonBuilder = new StringBuilder();

            jsonBuilder.append("{\n");

            int i = 0;
            for(String key : map.keySet()) {

                // 숫자 타입, 문자 타입
                Object obj = map.get(key);

                if(obj instanceof String) {
                    String value = (String)map.get(key);
                    String tmp = "    \"%s\" : " + "\"%s\"";
                    jsonBuilder.append(tmp.formatted(key, value));

                } else if(obj instanceof Integer) {
                    int value = (int)map.get(key);
                    String tmp = "    \"%s\" : " + "%s";
                    jsonBuilder.append(tmp.formatted(key, value));
                }

                if(i == map.size() - 1) {
                    break;
                }

                jsonBuilder.append(",\n");
                i++;
            }

            jsonBuilder.append("\n}");

            return jsonBuilder.toString();
        }
    }
}
