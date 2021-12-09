package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 객체 생성")
    void create() {
        Point point1 = new Point(new Position(0), new Direction(false,true));
        Point point2 = new Point(new Position(1), new Direction(false,false));
        Point point3 = new Point(new Position(2), new Direction(false,true));
        Point point4 = new Point(new Position(3), new Direction(false,false));
        Line line1 = new Line(Arrays.asList(point1, point2, point3, point4));
        Point point5 = new Point(new Position(4), new Direction(false,false));
        Point point6 = new Point(new Position(5), new Direction(false,true));
        Point point7 = new Point(new Position(6), new Direction(false,false));
        Point point8 = new Point(new Position(7), new Direction(true,false));
        Line line2 = new Line(Arrays.asList(point5, point6, point7, point8));
        Ladder ladder = new Ladder(Arrays.asList(line1, line2));
        assertThat(ladder).isEqualTo(new Ladder(Arrays.asList(line1, line2)));
    }

}
