package ladder.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinResults {
    private List<String> winResults;
    private Map<Integer, String> winResultMap = new HashMap<>();

    public WinResults(List<String> winResults) {
        this.winResults = winResults;
    }

    public void createWinResultMap() {
        for (int i = 0; i < winResults.size(); i++) {
            winResultMap.put(i, winResults.get(i));
        }
    }

    public List<String> getWinResults() {
        return winResults;
    }

    public String searchWinResult(Player player) {
        return winResultMap.get(player.getResult());
    }
}
