package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void movableFalseAndRightTest() {
        final Line line = new Line(Arrays.asList(false, true, false, true));
        final String movable = line.movable(0);
        assertThat(movable).isEqualTo("right");
    }

    @Test
    void movableFalseAndDownTest() {
        final Line line = new Line(Arrays.asList(false, true, false, false));
        final String movable = line.movable(2);
        assertThat(movable).isEqualTo("down");
    }

    @Test
    void movableFalseAndDownTest2() {
        final Line line = new Line(Arrays.asList(false, true, false, false));
        final String movable = line.movable(3);
        assertThat(movable).isEqualTo("down");
    }

    @Test
    void movableTrueAndLeftTest() {
        final Line line = new Line(Arrays.asList(false, true, false, true));
        final String movable = line.movable(1);
        assertThat(movable).isEqualTo("left");
    }

    @Test
    void movableTrueAndDownTest() {
        final Line line = new Line(Arrays.asList(true, false, false, true));
        final String movable = line.movable(0);
        assertThat(movable).isEqualTo("down");
    }
}
