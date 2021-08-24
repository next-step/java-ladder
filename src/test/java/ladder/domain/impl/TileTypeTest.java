package ladder.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TileTypeTest {

    @Test
    void first_right() {
        TileType first = TileType.first(true);
        assertThat(first).isEqualTo(TileType.RIGHT);
    }

    @Test
    void first_down() {
        TileType first = TileType.first(false);
        assertThat(first).isEqualTo(TileType.DOWN);
    }

    @Test
    void next_right() {
        TileType second = TileType.first(false).next(true);
        assertThat(second).isEqualTo(TileType.RIGHT);
    }

    @Test
    void next_down() {
        TileType second = TileType.first(false).next(false);
        assertThat(second).isEqualTo(TileType.DOWN);
    }

    @Test
    void next_leftFollowingRight() {
        assertThat(TileType.first(true).next(true));
    }

    @Test
    void last_left() {
        TileType last = TileType.first(true).last();
        assertThat(last).isEqualTo(TileType.LEFT);
    }

    @Test
    void last_down() {
        TileType last = TileType.first(false).last();
        assertThat(last).isEqualTo(TileType.DOWN);
    }
}
