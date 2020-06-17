package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.strategy.RandomStrategy;

public class Ladder {
    private final Players players;
    private final Lines lines;
    private final Results results;

    private Ladder(Players players, Results results, Lines lines) {
        this.players = players;
        this.results = results;
        this.lines = lines;
    }

    private Ladder(String[] playerNames, String[] ladderResults, int ladderHeight) {
        this(new Players(playerNames),
                new Results(playerNames.length, ladderResults),
                new Lines(new RandomStrategy(), playerNames.length, ladderHeight));
    }

    public static Ladder of(String[] playerNames, String[] ladderResults, int ladderHeight) {
        return new Ladder(playerNames, ladderResults, ladderHeight);
    }

    public Players getPlayers() {
        return players;
    }

    public Results getResults() {
        return results;
    }

    public Lines getLines() {
        return lines;
    }
}
