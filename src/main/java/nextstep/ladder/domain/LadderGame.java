package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {
    private final JoinMembers joinMembers;
    private final Ladder ladder;

    public LadderGame(JoinMembers joinMembers, Ladder ladder) {
        this.joinMembers = joinMembers;
        this.ladder = ladder;
    }

    public static LadderGame of(JoinMembers joinMembers, int height) {
        return new LadderGame(joinMembers,
                new Ladder(height, joinMembers.getNumberOfMembers())
        );
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Member> getMembers() {
        return joinMembers.getMembers();
    }
}
