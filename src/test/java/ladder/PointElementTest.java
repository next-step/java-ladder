package ladder;

import org.junit.jupiter.api.Test;

import static ladder.PointElement.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PointElementTest {
    @Test
    void firstElement() {
        assertThat(first(false)).isSameAs(PASS);
        assertThat(first(true)).isSameAs(RIGHT);
    }

    @Test
    void nextElement() {
        assertThat(first(true).nextElement(false)).isSameAs(LEFT);
        assertThat(first(false).nextElement(false)).isSameAs(PASS);
        assertThat(first(false).nextElement(true)).isSameAs(RIGHT);
    }

    @Test
    void lastElement() {
        assertThat(first(true).lastElement()).isSameAs(LEFT);
        assertThat(first(false).lastElement()).isSameAs(PASS);
    }

    @Test
    void move() {
        // given
        Position position = Position.of(1);

        // then
        assertThat(LEFT.move(position)).isSameAs(Position.of(0));
        assertThat(PASS.move(position)).isSameAs(position.of(1));
        assertThat(RIGHT.move(position)).isSameAs(position.of(2));
    }
}
