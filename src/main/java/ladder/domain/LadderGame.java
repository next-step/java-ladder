package ladder.domain;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }


    public Node findPlayerResult(final String playerName) {
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
