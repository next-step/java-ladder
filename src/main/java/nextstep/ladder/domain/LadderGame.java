package nextstep.ladder.domain;

import java.util.stream.IntStream;
import nextstep.ladder.domain.common.GameResults;

public class LadderGame {

    private final Players players;
    private final GameResults gameResults;
    private final HorizontalLines lines;

    private LadderGame(final Players players, final GameResults gameResults, final HorizontalLines lines) {
        IntStream.range(0, players.size())
            .forEach(i -> players.updateResult(i, gameResults.get(lines.move(i))));

        this.players = players;
        this.gameResults = gameResults;
        this.lines = lines;
    }

    public static LadderGame of(final Players players, final GameResults gameResults, final int height) {
        return new LadderGame(players, gameResults, HorizontalLines.of(height, players.size()));
    }

    public Players getPlayers() {
        return players;
    }

    public GameResults getGameResults() {
        return gameResults;
    }

    public HorizontalLines getLines() {
        return lines;
    }
}
