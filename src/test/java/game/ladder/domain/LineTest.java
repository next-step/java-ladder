package game.ladder.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 만들기() {
        final int blockSize = 3;
        Line line = new Line(blockSize);
        assertThat(line.getBlockSize()).isEqualTo(blockSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 만들기_0넣을때() {
        final int blockSize = 0;

        new Line(blockSize);
    }

    @Test
    public void 만들어진_블럭들_연속_채운블록_존재여부() {
        final int blockSize = 10;

        Line line = new Line(blockSize);

        List<Block> blocks = line.getBlocks();
        for (int i = 1; i < blockSize; i++) {
            Block before = blocks.get(i - 1);
            Block current = blocks.get(i);
            assertThat(before.isSequenceFilledBlock(current)).as(String.format("before : %d, after : %d", i - 1, i)).isFalse();
        }
    }

}