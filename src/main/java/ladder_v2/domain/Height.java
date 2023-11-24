package ladder_v2.domain;

public class Height {

    private final int height;

    public Height(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("Ladder는 최소 1개의 Line을 가져야 한다.");
        }
        this.height = height;
    }

    public int height() {
        return height;
    }
}
