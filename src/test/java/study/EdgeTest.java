package study;

import org.junit.jupiter.api.Test;
import study.core.Direction;
import study.core.Edge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EdgeTest {
    @Test
    void moveToLeft() {
        Edge edge = Edge.first(true).next(false);
        assertThat(edge.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void moveToRight() {
        Edge edge = Edge.first(false).next(true);
        assertThat(edge.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void pass() {
        Edge edge = Edge.first(false);
        assertThat(edge.move()).isEqualTo(Direction.PASS);
    }

    @Test
    void invalid() {
        Edge edge = Edge.first(true).next(true);
        assertThat(edge.isCurrent()).isEqualTo(false);
    }
}
