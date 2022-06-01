package ladder.domain;

import org.junit.jupiter.api.Test;

import static ladder.domain.Way.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WayTest {
    @Test
    void first() {
        assertThat(Way.first(true)).isEqualTo(RIGHT);
    }

    @Test
    void next() {
        assertThat(Way.first(true).next(false)).isEqualTo(LEFT);
    }

    @Test
    void right() {
        assertThat(Way.first(false).next(true)).isEqualTo(RIGHT);
    }

    @Test
    void left() {
        assertThat(Way.first(true).next(false)).isEqualTo(LEFT);
    }

    @Test
    void duplicatedTrueThrowsError() {
        assertThatThrownBy(() -> Way.first(true).next(true)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void last() {
        assertThat(Way.first(true).next(false).last()).isEqualTo(Way.of(false, false));
    }
}
