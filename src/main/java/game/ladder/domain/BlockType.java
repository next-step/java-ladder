package game.ladder.domain;

public enum BlockType {

    EMPTY(" "), FILLED("-");

    private String shape;

    BlockType(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return this.shape;
    }

    public String makeShapes(int width) {
        StringBuilder sb = new StringBuilder(width);
        for (int i = 0; i < width; i++) {
            sb.append(this.shape);
        }
        return sb.toString();
    }

}
