package nextstep.ladder.domain.laddergame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class LadderGameResultTest {

    @Test
    void create() {
        LadderGameResult ladderGameResult = new LadderGameResult();

        Assertions.assertThat(ladderGameResult).isNotNull();
    }

    @Test
    void create_map() {
        LadderGameResult ladderGameResult = new LadderGameResult(Map.of("test1", "5000"));

        Assertions.assertThat(ladderGameResult).isNotNull();
    }

    @Test
    void add_and_getResult() {
        LadderGameResult ladderGameResult = new LadderGameResult();

        ladderGameResult.add("test1", "5000");

        Assertions.assertThat(ladderGameResult.getResult("test1")).isEqualTo("5000");
    }

    @Test
    void getResultAll() {
        LadderGameResult ladderGameResult = new LadderGameResult(Map.of("test1", "5000"));

        Assertions.assertThat(ladderGameResult.getResultAll()).contains("test1");
        Assertions.assertThat(ladderGameResult.getResultAll()).contains(":");
        Assertions.assertThat(ladderGameResult.getResultAll()).contains("5000");
    }
}