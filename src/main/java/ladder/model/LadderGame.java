package ladder.model;

public class LadderGame {
    private final Members members;
    private final Ladder ladder;

    public LadderGame(Members members, Ladder ladder) {
        this.members = members;
        this.ladder = ladder;
    }

    public static LadderGame create(final Members members, final LadderHeight ladderHeight) {
        return new LadderGame(members, Ladder.create(members.count(), ladderHeight.getHeight()));
    }

    public Members getMembers() {
        return members;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
