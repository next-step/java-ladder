package nextstep.ladder.domain;

public class Ladder {

    private final int height;

    private final int width;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
