package app.standard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileTest {
    @Test
    @DisplayName("최초의 file test")
    void t1(){
        Util.File.test();
    }

    @Test
    @DisplayName("파일 생성. 내용이 없는 빈 파일 생성")
    void t2(){
        String file = "test.txt";

        Util.File.createFile(file); // 파일 생성

        assertThat(Files.exists(Paths.get(file))).isTrue();
    }

}
