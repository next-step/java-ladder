package study.core;

import java.util.Collections;
import java.util.Map;

public class Result {
    private final Map<PlayerName, Prize> results;

    public Result(Map<PlayerName, Prize> results) {
        this.results = results;
    }

    public Map<PlayerName, Prize> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public String getPrizeToStringByPlayerName(PlayerName playerName) {
        return getResults().get(playerName).getValue();
    }

}
