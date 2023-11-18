package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PointTest {

    @Test
    @DisplayName("오른쪽으로 이동을 한다")
    void move1() {
        Point point = new Point(Boolean.FALSE, Boolean.TRUE);

        Direction actual = point.move();
        Direction expected = Direction.RIGHT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽으로 이동을 한다")
    void move2() {
        Point point = new Point(Boolean.TRUE, Boolean.FALSE);

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

    @Test
    @DisplayName("시작점의 자기 자신은 조건 없이 자신의 가로선을 그린다")
    void newPoint1() {
        Point actual = Point.first(Boolean.TRUE);
        Point expected = new Point(Boolean.FALSE, Boolean.TRUE);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전점을 기준으로 왼쪽 선을 그린다")
    void newPoint2() {
        Point point = Point.first(Boolean.TRUE);

        Point actual = point.draw(false);
        Point expected = new Point(true, false);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전점을 기준으로 마지막 점을 그린다")
    void newPoint3() {
        Point point = Point.first(Boolean.TRUE);
        point = point.draw(false);

        Point actual = point.last();
        Point expected = new Point(false, false);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전점을 기준으로 선이 있으면 그릴 수 없다")
    void canDrawNext() {
        Point point = Point.first(true);

        boolean actual = point.canDrawNext();
        boolean expected = false;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전점을 기준으로 선이 있으면 그릴 수 있다")
    void canDrawNext2() {
        Point point = Point.first(false);

        boolean actual = point.canDrawNext();
        boolean expected = true;

        assertThat(actual).isEqualTo(expected);
    }
}
