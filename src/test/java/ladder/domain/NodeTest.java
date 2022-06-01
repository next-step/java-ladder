package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NodeTest {
    @Test
    void first() {
        assertThat(Node.first(true).isRight()).isTrue();
    }

    @Test
    void next() {
        assertThat(Node.first(true).next(false).isLeft()).isTrue();
    }

    @Test
    void right() {
        assertThat(Node.first(false).next(true).isRight()).isTrue();
    }

    @Test
    void left() {
        assertThat(Node.first(true).next(false).isLeft()).isTrue();
    }

    @Test
    void duplicatedTrueThrowsError() {
        assertThatThrownBy(() -> Node.first(true).next(true)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void last() {
        assertThat(Node.first(true).next(false).last()).isEqualTo(new Node(false, false));
    }
}
