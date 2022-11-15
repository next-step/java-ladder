package nextstep.ladder.domain;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private final int height;
    public Height(final int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이가 낮습니다. 최소 : " + MIN_HEIGHT);
        }
        this.height = height;
    }

    public int height() {
        return height;
    }
}
