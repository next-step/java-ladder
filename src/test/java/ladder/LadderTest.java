package ladder;

import ladder.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        Height ladderHeight = Height.of("5");
        Ladder ladder = Ladder.of(Height.of("5"), Players.of("p1,p2,p3"));
        List<Line> lines = ladder.getLines();
        Assertions.assertThat(lines.size()).isEqualTo(ladderHeight.getSize());
    }

    @Test
    @DisplayName("사다리 타기")
    void climbLadder() {
        Point leftWayPoint = new Point(Way.LEFT);
        Point rightWayPoint = new Point(Way.RIGHT);
        Point downWayPoint = new Point(Way.DOWN);
        Line line1 = new Line(Arrays.asList(downWayPoint, rightWayPoint, leftWayPoint));
        Line line2 = new Line(Arrays.asList(rightWayPoint, leftWayPoint, downWayPoint));
        List<Line> lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);

        Ladder ladder = Ladder.of(lines);
        Location resultLocation = ladder.climb(new Location(1));
        assertEquals(resultLocation, new Location(2));
    }
}
