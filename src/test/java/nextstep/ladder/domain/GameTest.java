package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @DisplayName("Player 리스트와 사다리높이를 매개변수로 게임을 생성한다.")
    @Test
    void create() {
        String playerNames = "pobi,honux,crong,jk";
        int ladderHeight = 5;
        assertThat(Game.of(playerNames, ladderHeight)).isEqualTo(Game.of(playerNames, ladderHeight));
    }
}
