package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private List<Line> lines;
    private Players players;

    public LadderGame(int height, Players players, BridgeDecision bridgeDecision) {
        this.players = players;
        this.lines = initializeLines(height, players.size(), bridgeDecision);
    }

    private static List<Line> initializeLines(int height, int userCount, BridgeDecision bridgeDecision) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(userCount, bridgeDecision.isBridgeTarge()));
        }
        return lines;
    }

    public Map<String, String> getAllPlayerResult(String[] result) {

        Map<String, String> playerResult = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            playerResult.put(players.getPlayerNames().get(i), result[getPlayerResultIndex(i)]);
        }
        return playerResult;
    }

    public int getPlayerResultIndex(int index) {
        int resultIndex = index;

        for (Line line : lines) {
            resultIndex = line.getLineIndex(resultIndex);
        }
        return resultIndex;
    }

    public Players getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lines;
    }
}
