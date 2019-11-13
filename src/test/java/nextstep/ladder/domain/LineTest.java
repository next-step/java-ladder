package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;
    private List<Direction> list = Arrays.asList(Direction.LEFT, Direction.RIGHT, Direction.LEFT);

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
}
