package ladder.domain;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        if (height < MIN_HEIGHT){
            throw new IllegalArgumentException("사다리 높이는 1보다 작을 수 없습니다.");
        }
        this.height = height;
    }

    public int height() {
        return height;
    }
}
