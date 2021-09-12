package nextstep.labber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("오른쪽으로 이동")
    void move_right() {
        Point point = Point.first(false);
        Line line = new Line(Arrays.asList(point ,point.next(true), point.next(false), point.last())) ;

        assertThat(line.move(1)).isEqualTo(Compass.RIGHT);
    }

    @Test
    @DisplayName("왼쪽으로 이동")
    void move_left() {
        Point point = Point.first(true);
        Line line = new Line(Arrays.asList(point ,point.next(false), point.next(false), point.last())) ;

        assertThat(line.move(1)).isEqualTo(Compass.LEFT);
    }

    @Test
    @DisplayName("아래로 이동")
    void move_down() {
        Point point = Point.first(false);
        Line line = new Line(Arrays.asList(point ,point.next(false), point.next(false), point.last())) ;

        assertThat(line.move(1)).isEqualTo(Compass.DOWN);
    }
}