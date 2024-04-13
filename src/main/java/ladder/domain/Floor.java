package ladder.domain;

public class Floor {
    public static final int MIN_HEIGHT = 2;
    private int height;

    public Floor(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 2보다 커야합니다.");
        }
        this.height = height;
    }
}
