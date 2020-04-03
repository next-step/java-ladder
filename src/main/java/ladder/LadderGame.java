package ladder;

public class LadderGame {

    private final Members members;
    private final Ladder ladder;

    private LadderGame(final Members members, final Ladder ladder) {
        this.members = members;
        this.ladder = ladder;
    }

    public static LadderGame newInstance(final Members members, final int ladderHeight) {
        return new LadderGame(members, Ladder.newInstance(members.size(), ladderHeight));
    }
}
