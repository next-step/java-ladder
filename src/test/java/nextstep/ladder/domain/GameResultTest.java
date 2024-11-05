package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {

    @DisplayName("참가자별 결과가 잘 조회되는지")
    @Test
    void getResultByParticipantNameTest() {
        GameResult gameResult = new GameResult(Map.of("pobi", "꽝", "honux", "5000"));
        assertThat(gameResult.getResultByParticipantName("pobi")).isEqualTo("꽝");
        assertThat(gameResult.getResultByParticipantName("honux")).isEqualTo("5000");
    }

    @DisplayName("참가자가 존재하지 않을 때 예외가 발생하는지")
    @Test
    void getResultByParticipantNameWithNotExistParticipant() {
        GameResult gameResult = new GameResult(Map.of("pobi", "꽝", "honux", "5000"));
        assertThatThrownBy(() -> gameResult.getResultByParticipantName("crong"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
