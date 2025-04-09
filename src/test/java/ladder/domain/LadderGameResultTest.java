package ladder.domain;

import ladder.Height;
import ladder.domain.ladderlinegenerator.FalseLadderLineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderGameResultTest {
    @DisplayName("사다리 게임 실행 결과 확인")
    @Test
    void ladderGameResultTest() {
        // given
        Players players = new Players(List.of("more", "much", "less"));
        List<String> results = List.of("result1", "result2", "result3");
        int height = 4;
        LadderGame ladderGame = new LadderGame(players, results, new Height(height));
        Ladder ladder = new Ladder(height, players.count(), new FalseLadderLineGenerator());

        // when
        LadderGameResult gameResult = ladderGame.play(ladder);

        // then
        for (int i = 0; i < players.count(); i++) {
            Player player = players.getPlayerAtIndex(i);
            Assertions.assertThat(gameResult.getResultFor(player)).isEqualTo(i);
        }
    }
}
