package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    @DisplayName("결과의 position 비교")
    void isEquals() {
        LadderResult ladderResult = LadderResult.of("1000", 2);
        assertThat(ladderResult.isEquals(new Position(2))).isTrue();
    }
}