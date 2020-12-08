package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {
    Points boxedPoints;

    @BeforeEach
    void setUp() {
        List<Point> points = new ArrayList<>();
        points.add(Point.of(Position.of(0), Direction.RIGHT));
        points.add(Point.of(Position.of(1), Direction.LEFT));
        points.add(Point.of(Position.of(2), Direction.DOWN));
        boxedPoints = new Points(points);
    }

    @Test
    @DisplayName("사다리의 한 가로라인이   |-----|     |   처럼 생겼을 때의 움직임을 테스트한다.")
    void movePointAtTest() {
        assertThat(boxedPoints.movePointAt(Position.of(0))).isEqualTo(Position.of(1));
        assertThat(boxedPoints.movePointAt(Position.of(1))).isEqualTo(Position.of(0));
        assertThat(boxedPoints.movePointAt(Position.of(2))).isEqualTo(Position.of(2));
    }
}
