package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("오른쪽으로 이동을 한다")
    void calculatePoint1() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE), 0);
        Direction actual = line.nextDirection(1);
        Direction expected = Direction.RIGHT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽으로 이동을 한다")
    void calculatePoint2() {
        Line line = new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE), 0);
        Direction actual = line.nextDirection(1);
        Direction expected = Direction.LEFT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동하지 않는다")
    void calculatePoint3() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE), 0);
        Direction actual = line.nextDirection(1);
        Direction expected = Direction.STAY;

        assertThat(actual).isEqualTo(expected);
    }
}
