package game.ladder.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 만들기() {
        final int blockSize = 3;
        Line line = Line.of(blockSize);
        assertThat(line.getBlockSize()).isEqualTo(blockSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 만들기_0넣을때() {
        final int blockSize = 0;

        Line.of(blockSize);
    }

    @Test
    public void 만들기_customLine() {
        final List<Block> blocks = Arrays.asList(Block.EMPTY_BLOCK, Block.EMPTY_BLOCK, Block.FILLED_BLOCK, Block.EMPTY_BLOCK);
        Line line = Line.customLine(blocks);
        assertThat(line.getBlockSize()).isEqualTo(blocks.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void customLine_만들기_첫번째가_채워진_블록일때() {
        List<Block> blocks = Arrays.asList(Block.FILLED_BLOCK, Block.EMPTY_BLOCK, Block.FILLED_BLOCK, Block.EMPTY_BLOCK);

        Line.customLine(blocks);
    }

    @Test(expected = IllegalArgumentException.class)
    public void customLine_만들기_Collection_크기가_1일때() {
        List<Block> blocks = Collections.singletonList(Block.EMPTY_BLOCK);

        Line.customLine(blocks);
    }

    @Test(expected = IllegalArgumentException.class)
    public void customLine_만들기_연속으로_채워진_블록_있을때() {
        List<Block> blocks = Arrays.asList(Block.EMPTY_BLOCK, Block.FILLED_BLOCK, Block.FILLED_BLOCK);

        Line.customLine(blocks);
    }

    @Test
    public void 다음_position() {
        final List<Block> blocks = Arrays.asList(Block.EMPTY_BLOCK, Block.EMPTY_BLOCK, Block.FILLED_BLOCK, Block.EMPTY_BLOCK);
        final Line line = Line.customLine(blocks);

        final Position secondEmptyPosition = new Position(1);
        final Position filledPosition = new Position(2);
        final Position lastEmptyPosition = new Position(3);

        Position result1 = line.computeNextLinePosition(secondEmptyPosition);
        assertThat(result1).isEqualTo(secondEmptyPosition);

        Position result2 = line.computeNextLinePosition(filledPosition);
        assertThat(result2).isEqualTo(lastEmptyPosition);

        Position result3 = line.computeNextLinePosition(lastEmptyPosition);
        assertThat(result3).isEqualTo(filledPosition);
    }

    @Test
    public void getStringLine() {
        final String exected = "     |-----|     ";
        final List<Block> blocks = Arrays.asList(Block.EMPTY_BLOCK, Block.FILLED_BLOCK);
        final Line line = Line.customLine(blocks);

        assertThat(line.getStringLine()).isEqualTo(exected);
    }
}