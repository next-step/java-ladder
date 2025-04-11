package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LadderGameTest {
    @Test
    void createTest() {
        LadderGame ladderGame = new LadderGame(List.of("pobi", "honux", "crong", "jk"), 5,
                new FakeGeneratorStrategy(true));

        assertThat(ladderGame).isNotNull();
    }
}
