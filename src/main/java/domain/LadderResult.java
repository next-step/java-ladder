package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
    private static final String ALL = "all";
    private Map<String, String> radderResults;

    private LadderResult(Players players, String[] results, Ladder ladder) {
        radderResults = new HashMap<>();

        for (int i = 0; i < players.countOfPlayers(); i++) {
            String playerName = players.getPlayer(i);
            String result = results[ladder.getLadderResultIndex(i)];
            radderResults.put(playerName, result);
        }
    }

    public static LadderResult of(Players players, String[] results, Ladder ladder) {
        return new LadderResult(players, results, ladder);
    }

    public String getResult(String who) {
        if (ALL.equals(who)) {
            return radderResults.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.joining("\n"));
        }

        if(!radderResults.containsKey(who)) {
            throw new IllegalArgumentException();
        }

        return radderResults.get(who);
    }
}
