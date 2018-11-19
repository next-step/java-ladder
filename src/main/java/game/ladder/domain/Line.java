package game.ladder.domain;

import spark.utils.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private static final String DELIMITER = "|";
    private static final int MIN_SIZE = 1;

    private final List<Block> blocks;

    private Line(int blockSize) {
        Assert.isTrue(blockSize >= MIN_SIZE, "blockSize는 1 이상이여야 합니다.");
        this.blocks = makeBlocks(blockSize);
    }

    private Line(Collection<Block> blocks) {
        this.blocks = new ArrayList<>(blocks);
        this.blocks.add(Block.EMPTY_BLOCK);
    }

    public static Line of(int blockSize) {
        return new Line(blockSize);
    }

    public static Line customLine(Collection<Block> blocks) {
        Block first = blocks.iterator().next();
        Assert.isTrue(!first.isFilled(), "첫번째 Block은 EMPTY 여야 합니다.");
        Assert.isTrue(blocks.size() > 1, "Collection의 크기는 1보다 커야 합니다.");
        Assert.isTrue(!containsSequenceFiledBlock(blocks), "연속으로 채워진 Block은 존재 할 수 없습니다.");
        return new Line(blocks);
    }

    private static boolean containsSequenceFiledBlock(Collection<Block> blocks) {
        Iterator<Block> iterator = blocks.iterator();
        Block before = iterator.next();
        while (iterator.hasNext()) {
            Block after = iterator.next();
            if (before.isFilled() && after.isFilled()) {
                return true;
            }
            before = after;
        }
        return false;
    }

    private List<Block> makeBlocks(int blockSize) {
        List<Block> list = new ArrayList<>(blockSize);
        list.add(Block.EMPTY_BLOCK);

        for (int i = 1; i < blockSize; i++) {
            Block before = list.get(i - 1);
            Block newBlock = Block.nextBlock(before);
            list.add(newBlock);
        }

        list.add(Block.EMPTY_BLOCK);

        return list;
    }

    public int getBlockSize() {
        return this.blocks.size() - 1;
    }

    public String getStringLine() {
        return this.blocks.stream().map(Block::toString).collect(Collectors.joining(DELIMITER));
    }

    public Position computeNextLinePosition(Position currentPosition) {
        if(isFilled(currentPosition.getValue())) {
            return new Position(currentPosition.nextValue());
        }

        if(isFilled(currentPosition.previousValue())) {
            return new Position(currentPosition.previousValue());
        }

        return currentPosition;
    }

    private boolean isFilled(int index) {
        return this.blocks.get(index).isFilled();
    }
}
