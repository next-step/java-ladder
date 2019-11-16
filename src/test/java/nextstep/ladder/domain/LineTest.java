package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;
    private List<Point> list = Arrays.asList(new Point(0, Direction.BOTTOM), new Point(0, Direction.RIGHT), new Point(0, Direction.RIGHT));

    @BeforeEach
    void setUp() {
        line = new Line(list);
    }

    @Test
    void height() {
        assertThat(line.height()).isEqualTo(list.size());
    }

    @Test
    void direction() {
        assertThat(line.getDirectionByHeight(1)).isEqualTo(Direction.RIGHT);
    }

    @Test
    void point() {
        assertThat(line.getPointByHeight(1)).isEqualTo(new Point(0, Direction.RIGHT));
    }
}
