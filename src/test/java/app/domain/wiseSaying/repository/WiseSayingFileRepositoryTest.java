package app.domain.wiseSaying.repository;

import app.domain.wiseSaying.WiseSaying;
import app.standard.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WiseSayingFileRepositoryTest {

    WiseSayingRepository wiseSayingRepository = new WiseSayingFileRepository();

    @Test
    @DisplayName("명언 저장")
    void t1() {

        WiseSaying wiseSaying = new WiseSaying(1, "aaa", "bbb");

        wiseSayingRepository.save(wiseSaying);

        String filePath = "db/test/wiseSaying/%d.json".formatted(wiseSaying.getId());

        boolean rst = Files.exists(Path.of(filePath));
        assertThat(rst).isTrue();

        Map<String, Object> map = Util.Json.readAsMap(filePath);
        WiseSaying savedWiseSaying = WiseSaying.fromMap(map);

        assertThat(wiseSaying).isEqualTo(savedWiseSaying);
    }

    @Test
    @DisplayName("명언 삭제")
    void t2() {

        WiseSaying wiseSaying = new WiseSaying(1, "aaa", "bbb");

        wiseSayingRepository.save(wiseSaying);

        String filePath = "db/test/wiseSaying/%d.json".formatted(wiseSaying.getId());

        boolean delRst= wiseSayingRepository.deleteById(wiseSaying.getId());
        boolean rst = Files.exists(Path.of(filePath));

        assertThat(rst).isFalse();
        assertThat(delRst).isTrue();
    }

    @Test
    @DisplayName("id로 명언 가져오기")
    void t3() {
        WiseSaying wiseSaying = new WiseSaying(1, "aaa", "bbb");
        wiseSayingRepository.save(wiseSaying);

        assertThat(Files.exists(Path.of("db/test/wiseSaying/%d.json".formatted(wiseSaying.getId())))).isTrue();

        Optional<WiseSaying> opWiseSaying = wiseSayingRepository.findById(wiseSaying.getId());
        WiseSaying foundWiseSaying = opWiseSaying.orElse(null);

        assertThat(foundWiseSaying).isNotNull();
        assertThat(foundWiseSaying).isEqualTo(wiseSaying);
    }
}