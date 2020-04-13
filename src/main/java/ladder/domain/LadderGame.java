package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public Map<String, String> getResultAll() {
        Map<String, String> result = new HashMap<>();

        for (Player player : players.getPlayers()) {
            result.putAll(getResult(player.getName()));
        }

        return result;
    }

    public Map<String, String> getResult(final String playerName) {
        Map<String, String> result = new HashMap<>();

        Node lastNode = findPlayerLastNode(playerName);
        String prize = findPrize(lastNode.getIndex());
        result.put(playerName, prize);

        return result;
    }

    private Node findPlayerLastNode(final String playerName) {
        Player player = players.findPlayer(playerName);
        return ladder.findLastNode(player.getIndex());
    }

    public String findPrize(final int prizeIndex) {
        return ladder.getLadderPrize(prizeIndex);
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
