package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private List<Line> lines;

    @BeforeEach
    void setUp() {
        List<Point> points1 = Arrays.asList(new Point(Boolean.TRUE), new Point(Boolean.FALSE),
                new Point(Boolean.TRUE), new Point(Boolean.FALSE));

        List<Point> points2 = Arrays.asList(new Point(Boolean.FALSE), new Point(Boolean.TRUE),
                new Point(Boolean.FALSE), new Point(Boolean.FALSE));

        List<Point> points3 = Arrays.asList(new Point(Boolean.TRUE), new Point(Boolean.FALSE),
                new Point(Boolean.FALSE), new Point(Boolean.FALSE));

        lines = Arrays.asList(new Line(points1), new Line(points2), new Line(points3));

    }

    @Test
    @DisplayName("사다리라인 생성 테스트")
    void linesSizeTest() {
        MatchUp matchUp = new MatchUp("a,b,c,d", "1,2,3,4");
        Ladder ladder = new Ladder(() -> lines, matchUp);
        assertThat(ladder.getLadderLines()).hasSize(3);
    }

    @Test
    @DisplayName("각 라인내의 포인트 사이즈 테스트")
    void linesWithPointsOfLineTest() {
        MatchUp matchUp = new MatchUp("a,b,c,d", "1,2,3,4");
        Ladder ladder = new Ladder(() -> lines, matchUp);
        for (Line ladderLine : ladder.getLadderLines()) {
            assertThat(ladderLine.types()).hasSize(4);
        }
    }

    @Test
    @DisplayName("사다리 결과 테스트")
    void linesMoveTest() {
        MatchUp matchUp = new MatchUp("a,b,c,d", "1000,2000,3000,4000");
        Ladder ladder = new Ladder(() -> lines, matchUp);
        assertThat(ladder.getResultValue(ladder.getPeople().get(0).getPosition())).isEqualTo("3000");
        assertThat(ladder.getResultValue(ladder.getPeople().get(1).getPosition())).isEqualTo("2000");
        assertThat(ladder.getResultValue(ladder.getPeople().get(2).getPosition())).isEqualTo("4000");
        assertThat(ladder.getResultValue(ladder.getPeople().get(3).getPosition())).isEqualTo("1000");
    }
}
