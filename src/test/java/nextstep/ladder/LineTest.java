package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    public void size() {
        assertThatThrownBy(() -> new Line(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 직전_가로선_있을때_테스트() {
        Line line = new Line(1);
        boolean before = true;
        boolean point = line.generatePoint(before);
        assertThat(point).isFalse();
    }
}
