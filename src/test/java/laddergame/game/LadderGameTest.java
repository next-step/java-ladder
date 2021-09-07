package laddergame.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 게임은")
class LadderGameTest {

    @DisplayName("사람들 이름과, 사다리 높이로 초기화된다.")
    @Test
    void create() {
        LadderGame ladderGame = LadderGame.valueOf("pobi,honux,crong,jk", 5);
        assertThat(ladderGame).isEqualTo(ladderGame);
    }
}
