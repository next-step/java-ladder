package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("포인트를 받아 라인을 생성한다")
    @Test
    void create() {
        Point leftmostPoint = Point.createLeftmost(true);
        List<Point> points = List.of(
                leftmostPoint,
                leftmostPoint.createRightmost()
        );
        Line line = new Line(points);

        assertThat(line.width()).isEqualTo(2);
    }

    @DisplayName("포인트가 null이면 예외가 발생한다")
    @Test
    void nullPoints() {
        assertThatThrownBy(() -> new Line(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("포인트가 비어있으면 예외가 발생한다")
    @Test
    void emptyPoints() {
        assertThatThrownBy(() -> new Line(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시작 포인트가 왼쪽으로 이동 가능하면 예외가 발생한다")
    @Test
    void firstPointCannotMoveLeft() {
        List<Point> points = List.of(
                new Point(0, true, false),
                new Point(1, false, false)
        );

        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("마지막 포인트가 오른쪽으로 이동 가능하면 예외가 발생한다")
    @Test
    void lastPointCannotMoveRight() {
        List<Point> points = List.of(
                new Point(0, false, false),
                new Point(1, false, true)
        );

        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 가능한 포인트간에 서로 이동 가능하지 않으면 예외가 발생한다")
    @Test
    void hasMovableConnectionToNext() {
        List<Point> points = List.of(
                new Point(0, false, true),
                new Point(1, false, false)
        );

        assertThatThrownBy(() -> new Line(points))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("인덱스를 받아 포인트를 반환한다")
    @Test
    void getPoint() {
        Point leftmostPoint = Point.createLeftmost(true);
        List<Point> points = List.of(
                leftmostPoint,
                leftmostPoint.createRightmost()
        );
        Line line = new Line(points);

        assertThat(line.getPoint(0)).isEqualTo(leftmostPoint);
    }

}
