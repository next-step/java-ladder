package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NodeTest {
    @Test
    void first() {
        assertThat(Node.first(true).move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void next() {
        Direction direction = Node.first(true).next(false).move();
        assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @Test
    void down() {
        Direction direction = Node.first(false).next(false).move();
        assertThat(direction).isEqualTo(Direction.DOWN);
    }

    @Test
    void right() {
        Direction direction = Node.first(false).next(true).move();
        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    void left() {
        Direction direction = Node.first(true).next(false).move();
        assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @Test
    void duplicatedTrueThrowsError() {
        assertThatThrownBy(() -> Node.first(true).next(true).move()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void last() {
        Direction direction = Node.first(true).next(false).last().move();
        assertThat(direction).isEqualTo(Direction.DOWN);
    }
}
