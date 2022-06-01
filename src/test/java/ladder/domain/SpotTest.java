package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpotTest {
    @Test
    void right() {
        int to = new Spot(Way.first(true)).move(0);
        assertThat(to).isEqualTo(1);
    }

    @Test
    void left() {
        int to = new Spot(Way.first(true).next(false)).move(1);
        assertThat(to).isEqualTo(0);
    }

    @Test
    void down() {
        int to = new Spot(Way.first(false).next(false)).move(0);
        assertThat(to).isEqualTo(0);
    }
}
