package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void createLineOnlyTrue() {
        Line line = new Line(4, () -> true);
        assertThat(line.getPoints()).contains(true, false, true, false);
    }

    @Test
    void createLineOnlyFalse() {
        Line line = new Line(4, () -> false);
        assertThat(line.getPoints()).contains(false, false, false, false);
    }

    @Test
    void getSize() {
        Line line = new Line(4, () -> true);
        assertThat(line.getPoints().size()).isEqualTo(4);
    }
}