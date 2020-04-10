package ladder.domain;

import ladder.domain.type.DirectionType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @ParameterizedTest
    @CsvSource(value = {"0:RIGHT:1", "1:LEFT:0", "1:DOWN:1"}, delimiter = ':')
    void move(int index, DirectionType type, int expected) {
        Point point = new Point(index, type);

        int move = point.move();

        assertThat(move).isEqualTo(expected);
    }

    @Test
    void next() {
        Point point = new Point(0,  DirectionType.RIGHT);

        Point actualPoint = point.next();

        assertThat(actualPoint).isEqualTo(new Point(1, DirectionType.LEFT));
    }

    @ParameterizedTest
    @CsvSource(value = {"RIGHT:LEFT", "LEFT:DOWN", "DOWN:DOWN"}, delimiter = ':')
    void last(DirectionType type, DirectionType expected) {
        Point point = new Point(0,  type);

        Point actualPoint = point.last();

        assertThat(actualPoint).isEqualTo(new Point(1, expected));

    }

}
