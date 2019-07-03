package nextstep.ladder.view;

import nextstep.ladder.model.LadderLine;
import nextstep.ladder.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineFormatterTest {
    private LineFormatter lineFormatter;
    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        lineFormatter = new LineFormatter();

        List<Point> lines = new ArrayList<>();

        Point point = Point.first(true);
        lines.add(point);
        lines.add(point = point.next(false));
        lines.add(point = point.next(true));
        lines.add(point.last());

        ladderLine = new LadderLine(lines);
    }

    @DisplayName("Line |-----|     |-----|")
    @Test
    void formatTest() {
        assertThat(lineFormatter.format(ladderLine)).isEqualTo("     |-----|     |-----|\n");
    }
}
