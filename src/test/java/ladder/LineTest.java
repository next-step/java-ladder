package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void createLineOnlyTrue() {
        Line line = new Line(4, () -> true);
        assertThat(line.size()).isEqualTo(4);
    }
}