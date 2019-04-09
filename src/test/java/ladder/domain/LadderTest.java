package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private List<Point> points;

    @Before
    public void setUp() throws Exception {
        Point point1 = new Point(false, true);
        Point point2 = new Point(true, false);
        points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
    }

    @Test
    public void 사다리생성_n명_높이n() {
        int countOfPersion = 3;
        int height = 3;
        Ladder ladder = new Ladder(countOfPersion, height);
        int countOfLine = ladder.lineCount();
        assertThat(countOfLine).isEqualTo(3);
        assertThat(ladder.ladderHeight()).isEqualTo(3);
    }

    @Test
    public void 라인생성() {
        int countOfPersion = 3;
        int height = 3;
        Ladder ladder = new Ladder(countOfPersion, height);

    }
}
