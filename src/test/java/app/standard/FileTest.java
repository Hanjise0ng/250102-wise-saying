package app.standard;

import org.junit.jupiter.api.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {

    // 테스트 시작 전에 test 폴더 생성
    @BeforeEach
    void beforeEach() {
        Util.File.createDir("testDB");
    }

    // 테스트 종료 후에 test 폴더 삭제
    @AfterEach
    void afterEach() {
        Util.File.deleteForce("testDB");
    }

    @Test
    @DisplayName("최초의 file test")
    void t1() {
        Util.File.test();
    }

    @Test
    @DisplayName("파일 생성. 내용이 없는 빈 파일 생성")
    void t2() {
        String file = "testDB/test.txt";

        Util.File.createFile(file); // 파일 생성

        assertThat(Files.exists(Paths.get(file))).isTrue();
    }

    @Test
    @DisplayName("파일 내용 읽어오기")
    void t3() {

        // 파일을 Hello, World 내용으로 생성
        String file = "testDB/test.txt";
        String testContent = "Hello, World!";

        Util.File.write(file, testContent);
        String content = Util.File.readAsString(file);

        assertThat(content).isEqualTo("Hello, World!");
    }

    @Test
    @DisplayName("파일 내용 수정")
    void t4() {
        String file = "testDB/test.txt";
        String writeContent = "modify content";
        Util.File.write(file, writeContent);

        String readContent = Util.File.readAsString(file);

        assertThat(readContent).isEqualTo(writeContent);
    }

    @Test
    @DisplayName("파일 삭제")
    void t5() {
        // 파일 생성
        String file = "testDB/test.txt";

        Util.File.createFile(file);
        // 존재여부 확인
        assertThat(Files.exists(Paths.get(file))).isTrue();

        // 파일 삭제
        Util.File.delete(file);
        // 존재여부 확인
        assertThat(Files.exists(Paths.get(file))).isFalse();
    }

    @Test
    @DisplayName("폴더 생성")
    void t6() {

        String dirPath = "test";

        Util.File.createDir(dirPath);

        assertThat(Files.exists(Paths.get(dirPath)))
                .isTrue();

        assertThat(Files.isDirectory(Path.of(dirPath)))
                .isTrue();

    }

    @Test
    @DisplayName("폴더 삭제")
    void t7() {

        String dirPath = "test";

        Util.File.delete(dirPath);

        assertThat(Files.exists(Paths.get(dirPath)))
                .isFalse();
    }

    @Test
    @DisplayName("파일 생성 -> 없는 폴더에 생성 시도하면 폴더를 생성한 후에 파일 생성")
    void t8() {
        String path = "testDB/test2/test.txt";

        Util.File.createFile(path);
        boolean rst = Files.exists(Paths.get(path));
        assertThat(rst).isTrue();
    }

    @Test
    @DisplayName("파일 삭제 -> 폴더가 비어있지 않을 때 안의 내용까지 같이 삭제")
    void t9() {
        String path = "testDB/test2/test.txt";

        Util.File.deleteForce(path); // 강제 삭제

        boolean rst = Files.exists(Paths.get(path));
        assertThat(rst).isFalse();
    }
    
    @Test
    @DisplayName("특정 폴더의 파일 목록을 가져오기")
    void t10() {

        String path1 = "testDB/test1.txt";
        String path2 = "testDB/test2.txt";
        String path3 = "testDB/test3.txt";

        Util.File.write(path1, "content1");
        Util.File.write(path2, "content2");
        Util.File.write(path3, "content3");

        assertThat(Files.exists(Paths.get(path1))).isTrue();
        assertThat(Files.exists(Paths.get(path2))).isTrue();
        assertThat(Files.exists(Paths.get(path3))).isTrue();

        List<Path> paths = Util.File.getPaths("testDB/");

        assertThat(paths)
                .hasSize(3)
                .contains(Paths.get(path1))
                .contains(Paths.get(path2))
                .contains(Paths.get(path3));


    }

}
