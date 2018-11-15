package game.ladder.domain;

public class Block {

    public static final int WIDTH = 5;

    private final BlockType blockType;

    private Block(BlockType blockType) {
        this.blockType = blockType;
    }

    public static Block emptyBlock() {
        return new Block(BlockType.EMPTY);
    }

    public static Block filledBlock() {
        return new Block(BlockType.FILLED);
    }

    public BlockType getType() {
        return this.blockType;
    }

    @Override
    public String toString() {
        return blockType.makeShapes(WIDTH);
    }
}
