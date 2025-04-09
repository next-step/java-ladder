package laddergameRDD.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {
    @DisplayName("전체 게임 결과 생성 테스트")
    @Test
    void make_game_results() {
        Map<Integer, Integer> integerResults = new HashMap<>();
        integerResults.put(0, 0);

        assertThat(new GameResults(Arrays.asList("pobi"), Arrays.asList("꽝")).makeGameResults(integerResults))
                .containsExactly(new GameResult("pobi", "꽝"));
    }
}
