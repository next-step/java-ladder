package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DirectionTest {

    @Test
    void 왼쪽_이동() {
        assertThat(Direction.valueOf(true, false)).isEqualTo(Direction.LEFT);
    }

    @Test
    void 오른쪽_이동() {
        assertThat(Direction.valueOf(false, true)).isEqualTo(Direction.RIGHT);
    }

    @Test
    void 직진_이동() {
        assertThat(Direction.valueOf(false, false)).isEqualTo(Direction.STRAIGHT);
    }

    @Test
    void 오방향_입력_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            Direction.valueOf(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동값_조회() {
        assertThat(Direction.LEFT.getMovePosition()).isEqualTo(-1);
    }
}
