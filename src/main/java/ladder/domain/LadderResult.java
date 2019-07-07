package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    private final Ladder ladder;
    private final Players players;
    private final List<String> results;

    public LadderResult(Ladder ladder, Players players, List<String> results) {
        this.ladder = ladder;
        this.players = players;
        this.results = results;
    }

    public List<String> getTotalPlayersResult() {
        return players.getPlayersNames().stream()
                .map(name -> getPlayerResult(name))
                .collect(Collectors.toList());
    }

    public String getPlayerResult(String name) {
        int index = players.getPlayersNames().indexOf(name);
        return results.get(ladder.move(index));
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

    public List<String> getResults() {
        return results;
    }
}
