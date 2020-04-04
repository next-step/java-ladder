package nextstep.ladder;

public class Ladder {
    public static final String LADDER_HEIGHT_ERROR = "사다리 높이는 1보다 커야합니다.";
    private int height;

    public Ladder(int height) {
        assertLadderHeight(height);
        this.height = height;
    }

    private void assertLadderHeight(int height) {
        if(height < 1) {
            throw new IllegalArgumentException(LADDER_HEIGHT_ERROR);
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
