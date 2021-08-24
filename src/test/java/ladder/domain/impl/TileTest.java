package ladder.domain.impl;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.Test;

class TileTest {

    @Test
    void first() {
        assertThat(Tile.first(true).permute()).isEqualTo(1);
        assertThat(Tile.first(false).permute()).isEqualTo(0);
    }

    @Test
    void permute_left() {
        Tile second = Tile.first(true).next(false);
        assertThat(second.permute()).isEqualTo(0);
    }

    @Test
    void permute_down() {
        Tile second = Tile.first(false).next(false);
        assertThat(second.permute()).isEqualTo(1);
    }

    @Test
    void permute_right() {
        Tile second = Tile.first(false).next(true);
        assertThat(second.permute()).isEqualTo(2);
    }
}
