package ladder.domain.ladder.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ladder.domain.ladder.line.Line;
import ladder.domain.ladder.point.Point;
import ladder.dto.LadderResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        /*
         * 0     1     2     3
         * |-----|     |-----|
         * |     |-----|     |
         * 1     3     0     2
         *
         * permute(0) = 2
         * permute(1) = 0
         * permute(2) = 3
         * permute(3) = 1
         */

        /*
         * |-----|     |-----|
         */
        List<Point> topPoints = new ArrayList<>();
        Point point = Point.first(true);
        topPoints.add(point);
        point = point.next(false);
        topPoints.add(point);
        point = point.next(true);
        topPoints.add(point);
        point = point.last();
        topPoints.add(point);

        /*
         * |     |-----|     |
         */
        List<Point> bottomPoints = new ArrayList<>();
        point = Point.first(false);
        bottomPoints.add(point);
        point = point.next(true);
        bottomPoints.add(point);
        point = point.next(false);
        bottomPoints.add(point);
        point = point.last();
        bottomPoints.add(point);

        ladder = Ladder.of(Arrays.asList(Line.of(topPoints), Line.of(bottomPoints)));
    }

    @Test
    void permute_ReturnsLadderResult() {
        Map<Integer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(0, 2);
        expectedMap.put(1, 0);
        expectedMap.put(2, 3);
        expectedMap.put(3, 1);
        LadderResult expectedResult = LadderResult.of(expectedMap);

        LadderResult ladderResult = ladder.permute();

        assertThat(ladderResult).isEqualTo(expectedResult);
    }
}
