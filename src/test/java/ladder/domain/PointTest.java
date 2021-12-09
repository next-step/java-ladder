package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    @DisplayName("포인트 생성")
    void create() {
        Point point = new Point(new Position(3), new Direction(true, false));
        assertThat(point).isEqualTo(new Point(new Position(3), new Direction(true, false)));
    }

    @Test
    @DisplayName("Point 리스트 생성")
    void of() {
//        List<Point> points = Point.of(5);
//        assertThat(points).size().isEqualTo(6);
    }

    @Test
    @DisplayName("Point")
    void point() {

    }

}
