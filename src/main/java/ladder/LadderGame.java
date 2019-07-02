package ladder;

import java.util.List;

public class LadderGame {

    private Players players;
    private Ladder ladder;

    LadderGame(String playersNames, int ladderHeight) {
        this.players = new Players(playersNames);
        this.ladder = new Ladder(ladderHeight, players.size());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getPlayers() {
        return players.getPlayerList();
    }

}
