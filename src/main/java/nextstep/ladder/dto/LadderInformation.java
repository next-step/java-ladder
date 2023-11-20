package nextstep.ladder.dto;

public class LadderInformation {

    private final int width;
    private final Height height;

    public LadderInformation(int width,
                             Height height) {
        this.width = width;
        this.height = height;
    }

    public LadderInformation(int width,
                             int height) {
        this(width, new Height(height));
    }

    public int height() {
        return this.height.height();
    }

    public int width() {
        return this.width;
    }
}
