package game.ladder.domain;

public class Block {

    public static final Block EMPTY_BLOCK = new Block(BlockType.EMPTY);
    public static final Block FILLED_BLOCK = new Block(BlockType.FILLED);

    public static final int WIDTH = 5;

    private final BlockType blockType;

    private Block(BlockType blockType) {
        this.blockType = blockType;
    }

    public BlockType getType() {
        return this.blockType;
    }

    public boolean isSequenceFilledBlock(Block other) {
        return this.isFilledBlock() && this.equals(other);
    }

    private boolean isFilledBlock() {
        return this.equals(FILLED_BLOCK);
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
