package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class VerticalTest {
    @Test
    void create() {
        Vertical actual = new Vertical();
        Vertical expected = new Vertical(0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void moveDown() {
        Vertical vertical = new Vertical(1);
        Vertical actual = vertical.move();
        Vertical expected = new Vertical(2);

        assertThat(actual).isEqualTo(expected);
    }
}
