package ladder;

import ladder.dto.PlayerResult;
import ladder.dto.PlayerResults;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerResultsTest {
    @Test
    void 플레이어이름으로_결과값_찾기() {
        PlayerResults playerResults =
                new PlayerResults(List.of(
                        new PlayerResult("abc", "꽝")
                        , new PlayerResult("nnn", "당첨")));
        assertThat(playerResults.getResultValueByPlayerName("nnn")).isEqualTo("당첨");
    }
}
