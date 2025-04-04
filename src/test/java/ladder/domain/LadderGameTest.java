package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {

    @DisplayName("사다리 게임 생성")
    @Test
    void createLadderGame() {
        // given
        Players players = new Players(List.of("more", "much", "less"));
        int width = 4;
        LadderGame ladderGame = new LadderGame(players, width);

        // when
        Ladder ladder = ladderGame.createLadder();

        // then
        Assertions.assertThat(ladder)
                .satisfies(l -> {
                    Assertions.assertThat(l.height()).isEqualTo(players.count());
                    Assertions.assertThat(l.width()).isEqualTo(width);
                });

    }

}
