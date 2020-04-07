package ladder.model.dto;

import ladder.model.LadderGameReword;
import ladder.model.Member;

public class LadderPoleInfo {

    private final Member member;
    private final LadderGameReword ladderGameReword;

    private LadderPoleInfo(final Member member, final LadderGameReword ladderGameReword) {
        this.member = member;
        this.ladderGameReword = ladderGameReword;
    }

    public static LadderPoleInfo newInstance(final Member member, final LadderGameReword ladderGameReword) {
        return new LadderPoleInfo(member, ladderGameReword);
    }

    public Member getMember() {
        return member;
    }

    public LadderGameReword getLadderGameReword() {
        return ladderGameReword;
    }
}
