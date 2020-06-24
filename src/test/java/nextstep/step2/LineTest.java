package nextstep.step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void of() {
        Line line = Line.of(true);
        assertThat(line.isLine()).isTrue();
    }

    @Test
    void falseIfPreviousLineIsTrue() {
        Line line = Line.of(true);
        Line next = line.next();
        assertThat(next).isEqualTo(Line.of(false));
    }
}
