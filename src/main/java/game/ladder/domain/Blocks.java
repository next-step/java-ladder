package game.ladder.domain;

import spark.utils.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Blocks {

    private static final String DELIMITER = "|";
    private static final int MIN_SIZE = 1;

    private final List<Block> blocks;

    public Blocks(int blockSize) {
        Assert.isTrue(blockSize >= MIN_SIZE, "blockSize는 1 이상이여야 합니다.");
        this.blocks = new ArrayList<>(blockSize);
        initBlocks(blockSize);
    }

    private void initBlocks(int blockSize) {
        this.blocks.add(Block.EMPTY_BLOCK);
        for (int i = 1; i < blockSize; i++) {
            Block before = this.blocks.get(i - 1);
            Block newBlock = BlockFactory.generateRandomBlock();
            if (before.isSequenceFilledBlock(newBlock)) {
                i--;
                continue;
            }
            this.blocks.add(newBlock);
        }
    }

    public int size() {
        return this.blocks.size();
    }

    List<Block> getBlocks() {
        return Collections.unmodifiableList(this.blocks);
    }

    public String getStringBlocks() {
        return this.blocks.stream().map(Block::toString).collect(Collectors.joining(DELIMITER)) + DELIMITER;
    }
}
