package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.DotFactory.single;

class LineTest {

    @Test
    void vertical() {
        final Line horizontalLine = LineFactory.horizontal(single("-"), single("-"), single("-"));
        final String expected = "---";
        assertThat(horizontalLine.print()).isEqualTo(expected);
    }

    @Test
    void horizontal() {
        final Line verticalLine = LineFactory.vertical(single("|"), single("|"), single("|"));
        final String expected = "" +
                "|\n" +
                "|\n" +
                "|";
        assertThat(verticalLine.print()).isEqualTo(expected);
    }
}