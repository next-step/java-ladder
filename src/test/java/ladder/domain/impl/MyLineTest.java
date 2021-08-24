package ladder.domain.impl;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import ladder.domain.engine.Line;
import org.junit.jupiter.api.Test;

class MyLineTest {

    @Test
    void permute_swapFirstTwo() {
        Tile first = Tile.first(true);
        Tile second = first.next(false);
        Tile third = second.last();
        Line line = MyLine.of(Arrays.asList(first, second, third));
        assertThat(line.permute(0)).isEqualTo(1);
        assertThat(line.permute(1)).isEqualTo(0);
        assertThat(line.permute(2)).isEqualTo(2);
    }

    @Test
    void permute_swapLastTwo() {
        Tile first = Tile.first(false);
        Tile second = first.next(true);
        Tile third = second.last();
        Line line = MyLine.of(Arrays.asList(first, second, third));
        assertThat(line.permute(0)).isEqualTo(0);
        assertThat(line.permute(1)).isEqualTo(2);
        assertThat(line.permute(2)).isEqualTo(1);
    }
}
