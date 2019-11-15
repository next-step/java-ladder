package ladder.domain;

import java.util.Objects;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(final int countOfPlayer, final int height) {
        final LadderMaker ladderMaker = new LadderMaker(new BasicLinkGenerationStrategy());
        this.ladder = ladderMaker.makeLadder(countOfPlayer, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGame that = (LadderGame) o;
        return Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
