package step4_ladderGame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @DisplayName("플레이어 포지션은 0 이상이여야 한다.")
    @Test
    void testCase1() {
        Assertions.assertThatThrownBy(() -> {
            Position.of(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
