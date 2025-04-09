package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderGameTest {
    @Test
    void createTest() {
        LadderGame ladderGame = new LadderGame("pobi,honux,crong,jk", 5);

        assertThat(ladderGame).isEqualTo(new LadderGame("pobi,honux,crong,jk", 5));
    }
}