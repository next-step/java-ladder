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

    public Map<String, String> getResult(final String playerName) {
        Map<String, String> result = new HashMap<>();

        Node lastNode = findPlayerLastNode(playerName);
        String prize = findPrize(lastNode.getIndex());
        result.put(playerName, prize);

        return result;
    }

    private Node findPlayerLastNode(final String playerName) {
        int playerIndex = players.findPlayer(playerName);
        return ladder.findLastNode(playerIndex);
    }

    public String findPrize(final int prizeIndex) {
        return ladder.getLadderPrize().getPrize().get(prizeIndex);
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
