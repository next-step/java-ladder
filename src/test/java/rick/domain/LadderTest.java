package rick.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        /*
        |-| |
        | |-|
        | | |
        */
        List<List<Point>> points = Arrays.asList(
            Arrays.asList(Point.MOVABLE_POINT, Point.NON_MOVABLE_POINT),
            Arrays.asList(Point.NON_MOVABLE_POINT, Point.NON_MOVABLE_POINT),
            Arrays.asList(Point.NON_MOVABLE_POINT, Point.MOVABLE_POINT)
        );
        Queue<List<Point>> pointCreationQueue = new LinkedList<>(points);

        List<Line> expectedLines = points.stream()
            .map(Line::new)
            .collect(Collectors.toList());

        Ladder inputLadder = new Ladder(3, 3, (countOfPerson) -> pointCreationQueue.poll());
        Ladder expectedLadder = new Ladder(expectedLines);
        assertThat(inputLadder).isEqualTo(expectedLadder);
    }
}
