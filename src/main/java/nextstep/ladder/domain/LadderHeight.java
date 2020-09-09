package nextstep.ladder.domain;

public class LadderHeight {

    private final int ladderHeight;

    private LadderHeight(int ladderHeight) {
        this.ladderHeight = ladderHeight;
    }

    public static LadderHeight create(int ladderHeight) {
        return new LadderHeight(ladderHeight);
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
