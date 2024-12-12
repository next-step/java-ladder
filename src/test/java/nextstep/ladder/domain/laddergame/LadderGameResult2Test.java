package nextstep.ladder.domain.laddergame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class LadderGameResult2Test {

    @Test
    void create() {
        LadderGameResult2 ladderGameResult2 = new LadderGameResult2();

        Assertions.assertThat(ladderGameResult2).isNotNull();
    }

    @Test
    void create_map() {
        LadderGameResult2 ladderGameResult2 = new LadderGameResult2(Map.of("test1", "5000"));

        Assertions.assertThat(ladderGameResult2).isNotNull();
    }

    @Test
    void add_and_getResult() {
        LadderGameResult2 ladderGameResult2 = new LadderGameResult2();

        ladderGameResult2.add("test1", "5000");

        Assertions.assertThat(ladderGameResult2.getResult("test1")).isEqualTo("5000");
    }

    @Test
    void getResultAll() {
        LadderGameResult2 ladderGameResult2 = new LadderGameResult2(Map.of("test1", "5000"));

        Assertions.assertThat(ladderGameResult2.getResultAll()).contains("test1");
        Assertions.assertThat(ladderGameResult2.getResultAll()).contains(":");
        Assertions.assertThat(ladderGameResult2.getResultAll()).contains("5000");
    }
}