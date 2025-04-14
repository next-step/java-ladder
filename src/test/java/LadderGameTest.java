
import domain.Ladder;
import domain.LadderGameEngine;
import domain.PlayerName;
import domain.PlayerNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.ResultMapping;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    @DisplayName("플레이어가 사다리를 타고 도착한 결과를 반환한다")
    void ladderMoveResult() {
        // given
        PlayerNames playerNames = new PlayerNames(List.of(
                new PlayerName("kwon"),
                new PlayerName("ohgyu"),
                new PlayerName("sewon"),
                new PlayerName("park")
        ));

        List<String> results = List.of("꽝", "5000", "꽝", "10000");
        ResultMapping mapping = new ResultMapping(playerNames.getNames(), results);

        Ladder ladder = new Ladder(playerNames.size(), 5);  // 높이 5의 사다리 생성

        // when
        String result = LadderGameEngine.move(ladder, playerNames.indexOf(new PlayerName("kwon")), playerNames.getNames(), mapping);

        // then
        assertThat(results).contains(result);
    }

    @Test
    @DisplayName("모든 플레이어의 결과를 정확히 매핑한다")
    void allPlayerResults() {
        PlayerNames playerNames = new PlayerNames(List.of(
                new PlayerName("kwon"),
                new PlayerName("ohgyu"),
                new PlayerName("sewon"),
                new PlayerName("park")
        ));

        List<String> results = List.of("꽝", "5000", "꽝", "10000");
        ResultMapping mapping = new ResultMapping(playerNames.getNames(), results);

        Ladder ladder = new Ladder(playerNames.size(), 5);

        for (PlayerName player : playerNames.getNames()) {
            String result = LadderGameEngine.move(ladder, playerNames.indexOf(player), playerNames.getNames(), mapping);
            assertThat(results).contains(result);
        }
    }

    @Test
    @DisplayName("존재하지 않는 참가자에 대해 예외 발생")
    void invalidPlayerName() {
        PlayerNames playerNames = new PlayerNames(List.of(
                new PlayerName("kwon"),
                new PlayerName("ohgyu")
        ));

        boolean thrown = false;
        try {
            playerNames.findByName("sewon");
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertThat(thrown).isTrue();
    }
}
