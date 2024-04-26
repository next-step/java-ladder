package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    @Test
    void leftMove() {
        Direction direction = Direction.of(true, false);

        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void rightMove() {
        Direction direction = Direction.of(false, true);

        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void passMove() {
        Direction direction = Direction.of(false, false);

        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void exception() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연속으로 사다리가 놓일 수 없습니다.");
    }

    @Test
    void first() {
        Direction firstFalseTrue = Direction.first(true);
        Direction firstFalseFalse = Direction.first(false);

        assertThat(firstFalseTrue).isEqualTo(Direction.of(false, true));
        assertThat(firstFalseFalse).isEqualTo(Direction.of(false, false));
    }

    @Test
    void last() {
        Direction last = Direction.first(true).next(false).last();

        assertThat(last).isEqualTo(Direction.of(false, false));
    }

    @Test
    void nextWhenBeforeTrue() {
        Direction next = Direction.first(true).next();

        Assertions.assertThat(next).isEqualTo(Direction.of(true, false));
    }
}
