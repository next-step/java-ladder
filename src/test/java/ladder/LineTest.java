package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        List<Point> points = Arrays.asList(new Point(Boolean.FALSE), new Point(Boolean.TRUE));
        line = new Line(points);
    }

    @Test
    @DisplayName("하나의 라인에 포인트 체크")
    void checkPointOfLineTest() {
        assertThat(line.types()).containsExactly(Boolean.FALSE, Boolean.TRUE);
    }
}
