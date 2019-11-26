package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-19 03:22
 */
public class DirectionTest {
    @Test
    void 생성() {
        Direction direction = Direction.of(Boolean.FALSE, Boolean.FALSE);
        assertThat(direction).isEqualTo(Direction.of(Boolean.FALSE, Boolean.FALSE));
    }

    @Test
    void next() {
        Direction direction = Direction.of(Boolean.FALSE, Boolean.TRUE);
        assertThat(direction.next(false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    void move_right() {
        Direction direction = Direction.of(false, true);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void move_left_test() {
        Direction direction = Direction.of(true, false);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void move_pass_test() {
        Direction direction = Direction.of(false, false);
        assertThat(direction.move()).isEqualTo(0);
    }

    @Test
    void last() {
        Direction direction = Direction.of(false, true);
        assertThat(direction.last().move()).isEqualTo(-1);
    }
}
