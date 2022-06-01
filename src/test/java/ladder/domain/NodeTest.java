package ladder.domain;

import org.junit.jupiter.api.Test;

import static ladder.domain.Node.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NodeTest {
    @Test
    void first() {
        assertThat(Node.first(true)).isEqualTo(RIGHT);
    }

    @Test
    void next() {
        assertThat(Node.first(true).next(false)).isEqualTo(LEFT);
    }

    @Test
    void right() {
        assertThat(Node.first(false).next(true)).isEqualTo(RIGHT);
    }

    @Test
    void left() {
        assertThat(Node.first(true).next(false)).isEqualTo(LEFT);
    }

    @Test
    void duplicatedTrueThrowsError() {
        assertThatThrownBy(() -> Node.first(true).next(true)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void last() {
        assertThat(Node.first(true).next(false).last()).isEqualTo(Node.of(false, false));
    }
}
