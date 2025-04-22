package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderResults {
    private final Players players;
    private final Results matchedResults;

    private LadderResults(Players players, Results matchedResults) {
        this.players = players;
        this.matchedResults = matchedResults;
    }

    public static LadderResults from(Players players, Ladder ladder, Results results) {
        List<Result> resultList = results.getResults();

        List<Result> matched = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            int moved = ladder.move(i);
            matched.add(resultList.get(moved));
        }
        return new LadderResults(players, new Results(matched, players));
    }

    public List<Player> getPlayers() {
        return players.players();
    }

    public Result getResultOf(Player player) {
        int index = players.indexOf(player);
        return matchedResults.getResults().get(index);
    }
}
