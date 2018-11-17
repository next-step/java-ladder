package game.ladder.domain;

public class Line {

    private final Blocks blocks;

    public Line(int blockSize) {
        this.blocks = new Blocks(blockSize);
    }

    public int getBlockSize() {
        return this.blocks.size();
    }

    public String getStringLine() {
        return this.blocks.getStringBlocks();
    }
}
