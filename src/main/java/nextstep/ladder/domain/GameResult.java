package nextstep.ladder.domain;

import java.util.List;

public class GameResult {
    private final LadderResults ladderResults;
    private final Players players;

    public GameResult(LadderResults ladderResults, Players players) {
        this.ladderResults = ladderResults;
        this.players = players;
    }

    public static GameResult of(LadderResults ladderResults, Players players) {
        return new GameResult(ladderResults, players);
    }

    public List<Line> ladderLines() {
        return ladderResults.getLines();
    }

    public List<String> playerNames() {
        return players.names();
    }

    public Player player(String name) {
        return players.player(name);
    }

    public String playerResult(int position) {
        return ladderResults.getLadderResult(position);
    }

    public List<Player> players() {
        return players.players();
    }

    public String ladderResult(int position) {
        return ladderResults.getLadderResult(position);
    }

    public List<String> resultValues() {
        return ladderResults.results()
                .values();
    }
}
