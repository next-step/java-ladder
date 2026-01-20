package nextstep.ladder.domain;

import nextstep.ladder.factory.LineFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final Results results;

    private LadderGame(Players players, Ladder ladder, Results results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    public static LadderGame of(String names, String results, int height, LineFactory factory) {
        Players players = new Players(names);
        Results result = new Results(results);
        Ladder ladder = new Ladder(height, players.getSize(), factory);

        return new LadderGame(players, ladder, result);
    }

    public List<Player> getPlayers() {
        return this.players.getPlayers();
    }

    public List<Result> getResults() {
        return this.results.getResults();
    }

    public List<Line> getLines() {
        return this.ladder.getLines();
    }

    public Result play(String playerName) {
        return results.findResultByIndex(ladder.move(players.indexOf(playerName)));
    }

    public List<Result> playAll() {
        return players.getPlayers().stream()
                .map(player -> play(player.getName()))
                .collect(Collectors.toList());
    }
}
