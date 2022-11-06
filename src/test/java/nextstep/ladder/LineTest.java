package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    void null_input() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(null));
    }

    @Test
    void single() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(List.of(true)));
    }

    @Test
    void consecutive() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(List.of(true, true)));
    }

    @Test
    void connected() {
        Line line = new Line(List.of(true, false, true));
        assertThat(line.connected(0)).isTrue();
        assertThat(line.connected(1)).isFalse();
        assertThat(line.connected(2)).isTrue();
        assertThatIllegalArgumentException().isThrownBy(() -> line.connected(3));
    }
}
