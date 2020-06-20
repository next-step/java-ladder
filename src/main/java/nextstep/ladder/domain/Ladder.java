package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.LadderResults;
import nextstep.ladder.strategy.RandomStrategy;

public class Ladder {
    private final Players players;
    private final Lines lines;
    private final LadderResults ladderResults;

    private Ladder(Players players, LadderResults ladderResults, Lines lines) {
        this.players = players;
        this.ladderResults = ladderResults;
        this.lines = lines;
    }

    private Ladder(String[] playerNames, String[] ladderResults, int ladderHeight) {
        this(new Players(playerNames),
                new LadderResults(playerNames.length, ladderResults),
                new Lines(new RandomStrategy(), playerNames.length, ladderHeight));
    }

    public static Ladder of(String[] playerNames, String[] ladderResults, int ladderHeight) {
        return new Ladder(playerNames, ladderResults, ladderHeight);
    }

    public Players getPlayers() {
        return players;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }

    public Lines getLines() {
        return lines;
    }
}
