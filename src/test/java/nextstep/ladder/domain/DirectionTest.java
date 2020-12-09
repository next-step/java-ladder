package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("Direction Exception Test - 양방향으로 갈수 없음")
    @Test
    public void directionExceptionTest() {
        assertThatThrownBy(() -> {
            Direction.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
