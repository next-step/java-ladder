package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PointTest {

    @Test
    @DisplayName("오른쪽으로 이동을 한다")
    void move1() {
        Point point = new Point(Boolean.TRUE, Boolean.FALSE);

        Direction actual = point.move();
        Direction expected = Direction.RIGHT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽으로 이동을 한다")
    void move2() {
        Point point = new Point(Boolean.FALSE, Boolean.TRUE);

        Direction actual = point.move();
        Direction expected = Direction.LEFT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동하지 않는다")
    void move3() {
        Point point = new Point(Boolean.FALSE, Boolean.FALSE);

        Direction actual = point.move();
        Direction expected = Direction.STAY;

        assertThat(actual).isEqualTo(expected);
    }

}
