package nextstep.ladder;

public class Height {

    private static final int MIN = 0;
    private final int height;

    public Height(int height) {
        if (valid(height)) {
            throw new IllegalArgumentException("사다리의 높이는 0이하 일 수 없습니다.");
        }
        this.height = height;
    }

    private static boolean valid(int height) {
        return height <= MIN;
    }
}
