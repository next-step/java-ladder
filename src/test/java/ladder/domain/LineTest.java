package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void line() {
        Line line = new Line(Arrays.asList(true, false, true, false));

        assertThat(line.getPoints()).hasSize(4);
    }
}
