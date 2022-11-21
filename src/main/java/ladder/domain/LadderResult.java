package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {

    private final Players players;
    private final Results results;

    public LadderResult(Players players, Results results) {
        this.players = players;
        this.results = results;
    }

    public List<String> resultList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < players.playerSize(); i++) {
            list.add(players.names().get(i) + " : " + results.results().get(i));
        }
        return list;
    }
}
