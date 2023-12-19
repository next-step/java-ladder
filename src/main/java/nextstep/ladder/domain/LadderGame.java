package nextstep.ladder.domain;

public class LadderGame {
    private final JoinMembers joinMembers;
    private final Ladder ladder;

    public LadderGame(JoinMembers joinMembers, int height) {
        this(joinMembers, new Ladder(height, joinMembers.getNumberOfMembers()));
    }

    public LadderGame(JoinMembers joinMembers, Ladder ladder) {
        this.joinMembers = joinMembers;
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public JoinMembers getJoinMembers() {
        return joinMembers;
    }
}
