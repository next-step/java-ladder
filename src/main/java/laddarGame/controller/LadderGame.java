package laddarGame.controller;

import laddarGame.domain.Players;

public class LadderGame {

    private Players players;
    private int ladderHeight;

    public LadderGame(String playerNames, int ladderHeight) {
        this.players = new Players(playerNames);
        this.ladderHeight = ladderHeight;
    }
}
