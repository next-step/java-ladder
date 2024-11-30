package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class VerticalTest {
    @Test
    @DisplayName("사다리의 현재 높이를 생성한다")
    void create() {
        Vertical actual = new Vertical();
        Vertical expected = new Vertical(0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 높이를 이동시킨다")
    void moveDown() {
        Vertical vertical = new Vertical(1);
        Vertical actual = vertical.move();
        Vertical expected = new Vertical(2);

        assertThat(actual).isEqualTo(expected);
    }
}
