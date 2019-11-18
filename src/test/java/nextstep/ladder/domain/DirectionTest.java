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
        Direction direction = Direction.first();
        assertThat(direction).isEqualTo(Direction.first());
    }

    @Test
    void next() {
        Direction direction = Direction.first();
        assertThat(direction.next(true)).isEqualTo(Direction.of(false, true));
    }
}
