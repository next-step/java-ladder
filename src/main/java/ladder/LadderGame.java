package ladder;

import java.util.Objects;

public class LadderGame {

    private final Members members;
    private final Ladder ladder;

    private LadderGame(final Members members, final Ladder ladder) {
        this.members = members;
        this.ladder = ladder;
    }

    public static LadderGame newInstance(final Members members, final LadderHeight ladderHeight) {
        return new LadderGame(members, Ladder.newInstance(members.count(), ladderHeight));
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
