package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    void create() {
        assertThat(Direction.init(true).isNext()).isTrue();
    }

    @Test
    void create2() {
        assertThat(Direction.of(false, true)).isEqualTo(Direction.init(true));
    }

    @Test
    void create3() {
        assertThatThrownBy(() -> Direction.of(true, true)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 마지막 라인 오른쪽은 가로 라인이 올 수 없다")
    void last() {
        for (int i = 0; i < 100; i++) {
            assertThat(Direction.init(false).next().last().isNext()).isFalse();
        }
    }

    @Test
    void next() {
        for (int i=0; i<100; i++) {
            assertThat(Direction.init(true).next().isNext()).isFalse();
        }
    }
}