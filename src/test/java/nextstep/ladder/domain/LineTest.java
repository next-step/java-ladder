package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void create() {
        assertThatCode(() -> Line.of(5, new RandomBooleanStrategy())).doesNotThrowAnyException();
    }

    @Test
    void nextHorizontalNumber() {
        Line line = Line.of(Arrays.asList(Point.of(true), Point.of(false)));
        assertThat(line.nextHorizontalNumber(0)).isEqualTo(1);
    }
}
