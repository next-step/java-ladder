package game.ladder.domain;

import spark.utils.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final String DELIMITER = "|";
    private static final int MIN_SIZE = 1;

    private final List<Block> blocks;

    public Line(int blockSize) {
        Assert.isTrue(blockSize >= MIN_SIZE, "blockSize는 1 이상이여야 합니다.");
        this.blocks = makeBlocks(blockSize);
    }

    private List<Block> makeBlocks(int blockSize) {
        List<Block> list = new ArrayList<>(blockSize);
        list.add(Block.EMPTY_BLOCK);

        for (int i = 1; i < blockSize; i++) {
            Block before = list.get(i - 1);
            Block newBlock = Block.nextBlock(before);
            list.add(newBlock);
        }

        return list;
    }

    public int getBlockSize() {
        return this.blocks.size();
    }

    public String getStringLine() {
        return this.blocks.stream().map(Block::toString).collect(Collectors.joining(DELIMITER)) + DELIMITER;
    }
}
