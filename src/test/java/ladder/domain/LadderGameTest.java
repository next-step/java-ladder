package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {

    @DisplayName("사다리 게임 생성")
    @Test
    void createLadderGame() {
        // given
        int height = 5;
        int width = 4;
        LadderGame ladderGame = new LadderGame(height, width);

        // when
        Ladder ladder = ladderGame.createLadder();

        // then
        Assertions.assertThat(ladder)
                .satisfies(l -> {
                    Assertions.assertThat(l.height()).isEqualTo(height);
                    Assertions.assertThat(l.width()).isEqualTo(width);
                });

    }

}
