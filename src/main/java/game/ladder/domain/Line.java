package game.ladder.domain;

import spark.utils.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Block> blocks;

    public Line(int blockSize) {
        Assert.isTrue(isNotLowerThanOne(blockSize), "blockSize는 1 이상이여야 합니다.");
        this.blocks = new ArrayList<>(blockSize);
        makeBlocks(blockSize);
    }

    private boolean isNotLowerThanOne(int blockSize) {
        return blockSize >= 1;
    }

    private void makeBlocks(int blockSize) {
        this.blocks.add(BlockFactory.generateRandomBlock());
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

    public int getBlockSize() {
        return this.blocks.size();
    }

    public List<Block> getBlocks() {
        return Collections.unmodifiableList(this.blocks);
    }
}
