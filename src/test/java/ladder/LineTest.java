package ladder;

import ladder.domain.Line;
import ladder.domain.Location;
import ladder.domain.Point;
import ladder.domain.Way;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {

    @Test
    @DisplayName("라인 생성")
    void createLine() {
        assertDoesNotThrow(() -> new Line(5));
    }

    @Test
    @DisplayName("라인 이동시 왼쪽 오른쪽 한칸 범위내에서 움직인다.")
    void moveLine() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(Way.DOWN));
        points.add(new Point(Way.RIGHT));
        points.add(new Point(Way.LEFT));
        Line line = new Line(points);

        Location movedLocationFirst = line.move(new Location(0));
        assertEquals(movedLocationFirst, new Location(0));
        Location movedLocationSecond = line.move(new Location(1));
        assertEquals(movedLocationSecond, new Location(2));
        Location movedLocationThird = line.move(new Location(2));
        assertEquals(movedLocationThird, new Location(1));
    }
}
