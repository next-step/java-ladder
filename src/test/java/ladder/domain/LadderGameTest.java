package ladder.domain;

import ladder.Height;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameTest {

    @DisplayName("결과를 포함하는 사다리 게임 생성")
    @Test
    void createLadderGameWithResults() {
        // given
        Players players = new Players(List.of("more", "much", "less"));
        List<String> results = List.of("result1", "result2", "result3");
        int height = 4;
        LadderGame ladderGame = new LadderGame(players, results, new Height(height));

        // when
        Ladder ladder = ladderGame.createLadder();

        // then
        Assertions.assertThat(ladder)
                .satisfies(l -> {
                    Assertions.assertThat(l.width()).isEqualTo(players.count());
                    Assertions.assertThat(l.height()).isEqualTo(height);
                });
    }

}
