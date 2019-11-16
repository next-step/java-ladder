package ladder;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    private Lines lines;

    @BeforeEach
    void setUp() {
        List<Point> points1 = Arrays.asList(new Point(Boolean.FALSE), new Point(Boolean.TRUE),
                new Point(Boolean.FALSE), new Point(Boolean.FALSE));

        List<Point> points2 = Arrays.asList(new Point(Boolean.TRUE), new Point(Boolean.FALSE),
                new Point(Boolean.TRUE), new Point(Boolean.FALSE));

        List<Point> points3 = Arrays.asList(new Point(Boolean.TRUE), new Point(Boolean.FALSE),
                new Point(Boolean.TRUE), new Point(Boolean.FALSE));

        lines = new Lines(Arrays.asList(new Line(points1), new Line(points2), new Line(points3)));

    }

    @Test
    @DisplayName("사다리라인 생성 테스트")
    void linesSizeTest() {
        assertThat(lines.getLadderLines()).hasSize(3);
    }

    @Test
    @DisplayName("각 라인내의 포인트 사이즈 테스트")
    void linesWithPointsOfLineTest() {
        for (Line ladderLine : lines.getLadderLines()) {
            assertThat(ladderLine.types()).hasSize(4);
        }
    }
}
