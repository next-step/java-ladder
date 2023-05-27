package ladder.domain.ladder;

public class LadderHeight {

    private final int height;

    public LadderHeight(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이어야 합니다.");
        }
    }
}
