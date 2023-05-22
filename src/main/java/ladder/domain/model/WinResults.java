package ladder.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinResults {
    private List<WinResult> winResults;
    private Map<Integer, String> winResultMap = new HashMap<>();

    public WinResults(List<WinResult> winResults) {
        this.winResults = winResults;
    }

    public void createWinResultMap() {
        for (int i = 0; i < winResults.size(); i++) {
            winResultMap.put(i, winResults.get(i).getWinResult());
        }
    }

    public List<WinResult> getWinResults() {
        return winResults;
    }

    public String searchWinResult(Player player) {
        return winResultMap.get(player.getResult());
    }

    public List<String> searchWinResults(Players players) {
        return players.getPlayers().stream()
                .map(player -> winResultMap.get(player.getResult()))
                .collect(Collectors.toList());
    }
}
