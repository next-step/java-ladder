package nextstep.domain.ladder;

public class LadderHeight {

    private final int ladderHeight;

    public LadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야 합니다.");
        }
        this.ladderHeight = ladderHeight;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

}
