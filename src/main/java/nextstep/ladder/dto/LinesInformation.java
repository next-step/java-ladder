package nextstep.ladder.dto;

public class LinesInformation {

    private final int width;
    private final Height height;

    public LinesInformation(int width,
                            Height height) {
        this.width = width;
        this.height = height;
    }

    public LinesInformation(int width,
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
