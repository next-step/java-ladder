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
    void nextPosition() {
        Line line = Line.of(Arrays.asList(Point.of(true), Point.of(false), Point.of(true), Point.of(false)));

        assertThat(line.nextPosition(0)).isEqualTo(1);
        assertThat(line.nextPosition(1)).isEqualTo(0);
        assertThat(line.nextPosition(2)).isEqualTo(3);
        assertThat(line.nextPosition(3)).isEqualTo(2);
        assertThat(line.nextPosition(4)).isEqualTo(4);

        line = Line.of(Arrays.asList(Point.of(false), Point.of(true), Point.of(false), Point.of(true)));

        assertThat(line.nextPosition(0)).isEqualTo(0);
        assertThat(line.nextPosition(1)).isEqualTo(2);
        assertThat(line.nextPosition(2)).isEqualTo(1);
        assertThat(line.nextPosition(3)).isEqualTo(4);
        assertThat(line.nextPosition(4)).isEqualTo(3);
    }
}
