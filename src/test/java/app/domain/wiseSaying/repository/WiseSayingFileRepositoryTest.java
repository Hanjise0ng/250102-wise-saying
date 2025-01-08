package app.domain.wiseSaying.repository;

import app.domain.wiseSaying.WiseSaying;
import app.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WiseSayingFileRepositoryTest {

    WiseSayingFileRepository wiseSayingFileRepository = new WiseSayingFileRepository();

    @Test
    @DisplayName("명언 저장")
    void t1() {

        WiseSaying wiseSaying = new WiseSaying(1, "aaa", "bbb");

        wiseSayingFileRepository.save(wiseSaying);

        // db/wiseSaying/1.json 존재 확인
        String filePath = "db/wiseSaying/%d.json".formatted(wiseSaying.getId());

        boolean rst = Files.exists(Path.of(filePath));
        assertThat(rst).isTrue();

        Map<String, Object> map = Util.Json.readAsMap(filePath);
        WiseSaying savedWiseSaying = WiseSaying.fromMap(map);

        assertThat(wiseSaying).isEqualTo(savedWiseSaying);
    }
}