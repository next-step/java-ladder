package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.exception.InvalidPointException;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void of_InvalidPoint() {
        Point point = Point.first(true);
        assertThatThrownBy(() ->
                point.next(true)
        ).isInstanceOf(InvalidPointException.class);
    }
}
