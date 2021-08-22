package nextstep.ladder.domain;

public class LadderHeight {

    private final int heightOfValue;

    private LadderHeight(int heightOfValue) {
        this.heightOfValue = heightOfValue;
    }

    public static LadderHeight of(int heightOfValue) {
        if (heightOfValue < 0) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이여합니다.");
        }

        return new LadderHeight(heightOfValue);
    }

    public int height() {
        return heightOfValue;
    }
}
