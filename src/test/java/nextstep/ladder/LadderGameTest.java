package nextstep.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    LadderGame ladderGame = new LadderGame();

    @ParameterizedTest
    @ValueSource(strings = "pobi,honux,crong,jk")
    void addPlayers(String input) {
        ladderGame.addPlayers(input);
        assertThat(ladderGame.getPlayerList()).hasSize(4);
    }

    @Test
    void saveLadder() {
        ladderGame.saveLadder(5);
        assertThat(ladderGame.getLadder().getHeight()).isEqualTo(5);
        assertThat(ladderGame.getLadder().getWidth()).isEqualTo(0);
    }

    @Test
    void addLine() {
        ladderGame.saveLadder(5);
        ladderGame.addLine();
        assertThat(ladderGame.getLineList()).hasSize(5);
    }

}
