package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SpotTest {
    @Test
    void right() {
        int to = new Spot(0, Way.first(true)).move();
        assertThat(to).isEqualTo(1);
    }

    @Test
    void left() {
        int to = new Spot(1, Way.first(true).next(false)).move();
        assertThat(to).isEqualTo(0);
    }

    @Test
    void down() {
        int to = new Spot(0, Way.first(false).next(false)).move();
        assertThat(to).isEqualTo(0);
    }
}
