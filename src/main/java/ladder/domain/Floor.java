package ladder.domain;

public class Floor {
    private int height;

    public Floor(int height) {
        if (height <= 1) {
            throw new IllegalArgumentException("사다리의 높이는 2보다 커야합니다.");
        }
        this.height = height;
    }
}
