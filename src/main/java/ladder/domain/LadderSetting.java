package ladder.domain;

public class LadderSetting {
    private final int ladderCount;
    private final int ladderHeight;

    public LadderSetting(int ladderCount, int ladderHeight) {
        this.ladderCount = ladderCount;
        this.ladderHeight = ladderHeight;
    }

    public int getLadderCount() {
        return ladderCount;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

}
