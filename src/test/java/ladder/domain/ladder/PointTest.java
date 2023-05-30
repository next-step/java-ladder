package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @Test
    @DisplayName("")
    void last() {
        Point point = Point.first(true).next(false).last();
        assertThat(point.move()).isEqualTo(Direction.SOUTH);
    }

    @Test
    @DisplayName("")
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("")
    void left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("")
    void right() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("")
    void invalidate() {
        assertThatThrownBy(() -> {
                    Point.first(true).next(true);
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("")
    void south() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(Direction.SOUTH);
    }
}
