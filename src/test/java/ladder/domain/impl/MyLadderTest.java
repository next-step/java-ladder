package ladder.domain.impl;

import static ladder.domain.impl.TileType.DOWN;
import static ladder.domain.impl.TileType.LEFT;
import static ladder.domain.impl.TileType.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import ladder.domain.engine.Ladder;
import ladder.dto.LadderResult;
import org.junit.jupiter.api.Test;

class MyLadderTest {

    @Test
    void permute() {
        List<Tile> topTiles = Arrays.asList(
                Tile.of(0, RIGHT), Tile.of(1, LEFT), Tile.of(2, DOWN));
        List<Tile> bottomTiles = Arrays.asList(
                Tile.of(0, DOWN), Tile.of(1, RIGHT), Tile.of(2, LEFT));
        Ladder ladder = MyLadder.of(Arrays.asList(MyLine.of(topTiles), MyLine.of(bottomTiles)));

        LadderResult expected = new LadderResult();
        expected.put(0, 2);
        expected.put(1, 0);
        expected.put(2, 1);

        LadderResult ladderResult = ladder.permute();

        assertThat(ladderResult).isEqualTo(expected);
    }
}
