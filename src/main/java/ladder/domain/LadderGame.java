package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.member.MemberGroup;

public class LadderGame {
    private final MemberGroup memberGroup;
    private final Ladder ladder;

    public LadderGame(MemberGroup memberGroup, Ladder ladder) {
        this.memberGroup = memberGroup;
        this.ladder = ladder;
    }
}
