package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {

    @Test
    @DisplayName("시작점의 자기 자신은 조건 없이 자신의 가로선을 그린다")
    void drawFirst() {
        Points actual = Points.drawFirst(true);
        Points expected = new Points(List.of(Point.first(true)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("전점을 기준으로 왼쪽 선을 그린다")
    void drawNext() {
        Points actual = Points.drawFirst(true);
        actual.drawNext(false);
        Point point = Point.first(true);
        Points expected = new Points(List.of(point, point.draw(false)));

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    @DisplayName("전점을 기준으로 마지막 점을 그린다")
    void drawLast() {
        Points actual = Points.drawFirst(true);
        actual.drawLast();
        Point point = Point.first(true);
        Points expected = new Points(List.of(point, point.last()));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("오른쪽으로 이동을 한다")
    void calculatePoint1() {
        Points points = Points.drawFirst(true);
        points.drawLast();
        Direction actual = points.nextDirection(0);
        Direction expected = Direction.RIGHT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽으로 이동을 한다")
    void calculatePoint2() {
        Points points = Points.drawFirst(true);
        points.drawLast();
        Direction actual = points.nextDirection(1);
        Direction expected = Direction.LEFT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동하지 않는다")
    void calculatePoint3() {
        Points points = Points.drawFirst(false);
        points.drawLast();
        Direction actual = points.nextDirection(0);
        Direction expected = Direction.STAY;

        assertThat(actual).isEqualTo(expected);
    }
}
