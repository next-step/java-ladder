package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    @Test
    void create() {
        LadderGame ladderGame = new LadderGame(6, 5);
        Assertions.assertThat(ladderGame.getLines()).hasSize(6);
    }
}
