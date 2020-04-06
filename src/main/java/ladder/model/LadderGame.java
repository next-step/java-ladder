package ladder.model;

import java.util.Objects;

public class LadderGame {

    private final Members members;
    private final Ladder ladder;

    private LadderGame(final Members members, final Ladder ladder) {
        validate(members, ladder);
        this.members = members;
        this.ladder = ladder;
    }

    private void validate(final Members members, final Ladder ladder) {
        MemberCount memberCount = members.count();
        if (memberCount.toInt() != ladder.getPoleCount()) {
            throw new IllegalArgumentException("Member count must be same as the ladder pole.");
        }
    }

    public static LadderGame newInstance(final Members members, final Ladder ladder) {
        return new LadderGame(members, ladder);
    }

    public static LadderGame newInstance(final String[] members, final Ladder ladder) {
        return newInstance(Members.newInstance(members), ladder);
    }

    public LadderGameResult start() {
        return LadderGameResult.newInstance(members, ladder.proceedAll());
    }

    public Members getMembers() {
        return members;
    }

    public Ladder getLadder() {
        return ladder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGame)) return false;
        LadderGame that = (LadderGame) o;
        return Objects.equals(getMembers(), that.getMembers()) &&
                Objects.equals(getLadder(), that.getLadder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMembers(), getLadder());
    }
}
