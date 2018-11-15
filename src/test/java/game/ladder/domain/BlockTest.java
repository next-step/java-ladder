package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BlockTest {

    @Test
    public void 만들기_비어있는_블록() {
        final Block block = Block.emptyBlock();
        final String expectedShapes = BlockType.EMPTY.makeShapes(Block.WIDTH);

        assertThat(block.getType()).isSameAs(BlockType.EMPTY);
        assertThat(block.toString()).isEqualTo(expectedShapes);
    }

    @Test
    public void 만들기_채워진_블록() {
        final Block block = Block.filledBlock();
        final String expectedShapes = BlockType.FILLED.makeShapes(Block.WIDTH);

        assertThat(block.getType()).isSameAs(BlockType.FILLED);
        assertThat(block.toString()).isEqualTo(expectedShapes);
    }


}