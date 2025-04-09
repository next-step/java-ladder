package laddergameRDD;

import laddergameRDD.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @DisplayName("게임 결과 생성 테스트")
    @Test
    void make_game_result() {
        assertThat(new GameResult("pobi", "꽝").getUserName()).isEqualTo("pobi");
    }
}
