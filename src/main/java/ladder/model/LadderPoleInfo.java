package ladder.model;

public class LadderPoleInfo {

    private final Member member;
    private final LadderGameReword ladderGameReword;

    private LadderPoleInfo(final Member member, final LadderGameReword ladderGameReword) {
        this.member = member;
        this.ladderGameReword = ladderGameReword;
    }

    public static LadderPoleInfo create(final Member member, final LadderGameReword ladderGameReword) {
        return new LadderPoleInfo(member, ladderGameReword);
    }

    public String getMemberName() {
        return member.getName();
    }

    public String getLadderGameReword() {
        return ladderGameReword.getReword();
    }
}
