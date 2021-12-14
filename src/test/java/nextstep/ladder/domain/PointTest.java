package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author han
 */
class PointTest {

    @Test
    void throwExceptionIfHasTrueAndTrue() {
        assertThatThrownBy(() -> {
            Point.init(true).next(true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void hasLineBefore() {
        Point point = Point.init(false).next(true);
        assertThat(point.hasLineBefore()).isEqualTo(true);
    }

    @Test
    void hasNotLineBefore() {
        Point point = Point.init(true).next(false);
        assertThat(point.hasLineBefore()).isEqualTo(false);
    }
}