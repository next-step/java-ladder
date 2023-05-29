package nextstep.ladder;

public class Height {

    private final static int ZERO = 0;
    private final long height;

    public Height(long height) {
        if (height <= ZERO) {
            throw new IllegalArgumentException("사다리 높이는 0 이하가 될 수 없습니다.");
        }
        this.height = height;
    }

    public long getHeight() {
        return height;
    }
}
