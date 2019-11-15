package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    public LadderGame(final String players, final int height) {
        final LadderMaker ladderMaker = new LadderMaker(new BasicLinkGenerationStrategy());
        this.players = new Players(players);
        this.ladder = ladderMaker.makeLadder(this.players.count(), height);
    }

    public List<String> getPlayerNames() {
        return this.players.getNames();
    }

    public Ladder getLadder() {
        return this.ladder;
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
