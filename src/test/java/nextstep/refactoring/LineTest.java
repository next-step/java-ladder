package nextstep.refactoring;

import nextstep.ladder.TrueGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    void create() {
        Line line = new Line(4, new TrueGenerator());
        assertThat(line).isNotNull();
    }

    @Test
    void move() {
        Line line = new Line(4, new TrueGenerator());
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    void invalidIndex() {
        Line line = new Line(4, new TrueGenerator());
        assertThatThrownBy(() -> line.move(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
