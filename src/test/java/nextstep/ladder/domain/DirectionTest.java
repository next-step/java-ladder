package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class DirectionTest {
    @Test
    @DisplayName("다음 Direction을 구하는 테스트")
    void next() {
        assertThat(Direction.RIGHT.next(true)).isEqualTo(Direction.LEFT);
        assertThat(Direction.LEFT.next(true)).isEqualTo(Direction.BOTTOM);
        assertThat(Direction.LEFT.next(false)).isIn(Direction.BOTTOM, Direction.RIGHT);
    }
}
