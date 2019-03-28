package ladder.vo;

public class LadderSize {
    private final Length width;
    private final Length height;

    public LadderSize(Length width, Length height) {
        this.width = width;
        this.height = height;
    }

    public Length getWidth() {
        return width;
    }

    public Length getHeight() {
        return height;
    }
}
