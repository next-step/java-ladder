package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    void LEFT_이동값은_마이너스1() {
        assertThat(Direction.LEFT.move()).isEqualTo(-1);
    }

    @Test
    void RIGHT_이동값은_1() {
        assertThat(Direction.RIGHT.move()).isEqualTo(1);
    }

    @Test
    void DOWN_이동값은_0() {
        assertThat(Direction.DOWN.move()).isEqualTo(0);
    }

    @Test
    void RIGHT만_isRight가_true() {
        assertThat(Direction.RIGHT.isRight()).isTrue();
        assertThat(Direction.LEFT.isRight()).isFalse();
        assertThat(Direction.DOWN.isRight()).isFalse();
    }
}