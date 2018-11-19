package game.ladder.domain;

import java.util.Random;

public class Block {

    public static final Block EMPTY_BLOCK = new Block(BlockType.EMPTY);
    public static final Block FILLED_BLOCK = new Block(BlockType.FILLED);

    public static final int WIDTH = 5;

    private static final Random RANDOM = new Random();

    private final BlockType blockType;

    private Block(BlockType blockType) {
        this.blockType = blockType;
    }

    public static Block nextBlock(Block before) {
        if (before.isFilled()) {
            return EMPTY_BLOCK;
        }

        if (RANDOM.nextBoolean()) {
            return FILLED_BLOCK;
        }

        return EMPTY_BLOCK;
    }

    public boolean isFilled() {
        return this == FILLED_BLOCK;
    }

    public BlockType getType() {
        return this.blockType;
    }

    @Override
    public String toString() {
        return blockType.makeShapes(WIDTH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block block = (Block) o;

        return blockType == block.blockType;
    }

    @Override
    public int hashCode() {
        return blockType.hashCode();
    }
}
