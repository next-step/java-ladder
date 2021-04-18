package ladder;

import ladder.domain.Direction;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    Ladder ladder = new Ladder();

    @BeforeEach
    void ladder() {
        int index = 0;

        Point point1 = new Point(index++, new Direction(false, true));
        Point point2 = new Point(index++, new Direction(true, false));
        Point point3 = new Point(index++, new Direction(false, false));

        Line ladderLine1 = new Line(Arrays.asList(point1, point2, point3));

        index = 0;
        Point point4 = new Point(index++, new Direction(false, false));
        Point point5 = new Point(index++, new Direction(false, true));
        Point point6 = new Point(index++, new Direction(true, false));

        Line ladderLine2 = new Line(Arrays.asList(point4, point5, point6));

        ladder.add(ladderLine1);
        ladder.add(ladderLine2);
    }

    @DisplayName("포인트를 입력 받아 사다리 라인을 그리고 이동결과를 반환한다.")
    @Test
    void arrival() {
        assertThat(ladder.arrivalPoint(0, 0)).isEqualTo(2);
        assertThat(ladder.arrivalPoint(0, 1)).isEqualTo(0);
        assertThat(ladder.arrivalPoint(0, 2)).isEqualTo(1);
    }
}
