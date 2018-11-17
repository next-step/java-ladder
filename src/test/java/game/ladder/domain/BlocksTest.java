package game.ladder.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BlocksTest {

    @Test(expected = IllegalArgumentException.class)
    public void 만들기_0넣을때() {
        final int blockSize = 0;

        new Blocks(blockSize);
    }

    @Test
    public void 만들어진_블럭들_연속_채운블록_존재여부() {
        final int blockSize = 10;
        Blocks blocks = new Blocks(blockSize);

        List<Block> blockList = blocks.getBlocks();
        for (int i = 1; i < blockSize; i++) {
            Block before = blockList.get(i - 1);
            Block current = blockList.get(i);
            assertThat(before.isSequenceFilledBlock(current)).as(String.format("before : %d, after : %d", i - 1, i)).isFalse();
        }
    }

}