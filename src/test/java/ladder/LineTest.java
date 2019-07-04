package ladder;

import ladder.domain.Line;
import ladder.domain.strategy.LineEvenStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineTest {

    @Test
    void create_invalid() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()-> new Line(Arrays.asList(false, true)));
    }

    @Test
    void move_pass() {
        Line line = new Line(Arrays.asList(false, false));
        assertThat(line.move(0)).isEqualTo(0);
    }

    @Test
    void move_right() {
        Line line = new Line(Arrays.asList(true, false));
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    void move_left() {
        Line line = new Line(Arrays.asList(true, false));
        assertThat(line.move(1)).isEqualTo(0);
    }
}
