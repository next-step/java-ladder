package step4.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MatchingResult {

    Map<step4.domain.Player, String> matchingResult;

    private MatchingResult(HashMap<Player, String> matchingResult) {
        this.matchingResult = matchingResult;
    }

    public static MatchingResult map(Players players, String[] winningPrize) {
        HashMap<Player, String> matchingResult = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            matchingResult.put(players.get(i), winningPrize[i]);
        }
        return new MatchingResult(matchingResult);
    }

    public int size() {
        return matchingResult.size();
    }

    public String getMatchedWinningPrizeOrederByPlayerName(String winner) {
        return matchingResult.keySet().stream()
                .filter(player -> player.isPlayerName(winner))
                .map(player -> player.getPlayerName())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Iterator<Player> getIterator() {
        return matchingResult.keySet().iterator();
    }

}
