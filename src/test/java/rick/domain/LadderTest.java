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
        List<Points> points = Arrays.asList(
            new Points(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, false))),
            new Points(Arrays.asList(new Point(false, false), new Point(false, true), new Point(true, false))),
            new Points(Arrays.asList(new Point(false, false), new Point(false, false), new Point(false, false)))
        );
        Queue<Points> pointCreationQueue = new LinkedList<>(points);

        List<Line> expectedLines = points.stream()
            .map(Line::new)
            .collect(Collectors.toList());

        Ladder inputLadder = new Ladder(3, 3, (countOfPerson) -> pointCreationQueue.poll());
        Ladder expectedLadder = new Ladder(expectedLines);
        assertThat(inputLadder).isEqualTo(expectedLadder);
    }
}
