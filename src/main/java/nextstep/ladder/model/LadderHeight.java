package nextstep.ladder.model;

public class LadderHeight {

    private static final int MIN_HEIGHT = 1;

    private final Integer heightOfLadder;

    public LadderHeight(Integer heightOfLadder) {
        validateHeight(heightOfLadder);
        this.heightOfLadder = heightOfLadder;
    }

    private void validateHeight(Integer heightOfLadder) {
        if (heightOfLadder < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 1 이상 이어야 합니다.");
        }
    }

    public Integer getHeightOfLadder() {
        return heightOfLadder;
    }
}
