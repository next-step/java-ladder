package nextstep.ladder.domain;

import nextstep.ladder.domain.line.LadderLines;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.result.LadderResults;

public class Ladder {
    private final Players players;
    private final LadderLines ladderLines;
    private final LadderResults ladderResults;

    private Ladder(Players players, LadderResults ladderResults, LadderLines ladderLines) {
        this.players = players;
        this.ladderResults = ladderResults;
        this.ladderLines = ladderLines;
    }

    private Ladder(String[] playerNames, String[] ladderResults, int ladderHeight) {
        this(new Players(playerNames),
                new LadderResults(playerNames.length, ladderResults),
                new LadderLines(playerNames.length, ladderHeight));
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

    public LadderLines getLadderLines() {
        return ladderLines;
    }
}
