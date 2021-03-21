package laddarGame.domain;

public class LadderGame {

    private final Ladder ladder;
    private final Players players;

    public LadderGame(String playerNames, int ladderHeight) {
        this.players = new Players(playerNames);
        this.ladder = new Ladder(players.maxNameLength(), players.playerCount(), ladderHeight);
    }

}