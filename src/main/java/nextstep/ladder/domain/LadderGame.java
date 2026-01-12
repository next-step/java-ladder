package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final Results results;


    public LadderGame(String players, Ladder ladder, String results) {
        this(new Players(players), ladder, new Results(results));
    }

    public LadderGame(Players players, Ladder ladder, Results results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
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
