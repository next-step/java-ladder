package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void listOf() {
        List<Line> lines = Line.listOf(3, 5);

        assertThat(lines).hasSize(5);
        assertThat(lines.get(0).getActions()).hasSize(3);
    }

    @Test
    void getMovePoint() {
        Line line = Line.listOf(3, 5).get(0);

        int actual = line.getMovePoint(0);

        assertThat(actual).isBetween(-1, 1);
    }
}
