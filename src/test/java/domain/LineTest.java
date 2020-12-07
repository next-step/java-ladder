package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;

    @BeforeEach
    void setUp() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(Position.of(0), Direction.RIGHT));
        points.add(Point.of(Position.of(1), Direction.LEFT));
        points.add(Point.of(Position.of(2), Direction.DOWN));
        Points boxedPoints = new Points(points);

        line = new Line(boxedPoints);
    }

    @Test
    @DisplayName("Points 클래스에게 메시지를 전송하는 move() 테스트")
    void moveTest() {
        assertThat(line.move(Position.of(0))).isEqualTo(Position.of(1));
        assertThat(line.move(Position.of(1))).isEqualTo(Position.of(0));
        assertThat(line.move(Position.of(2))).isEqualTo(Position.of(2));
    }

}
