package laddarGame.controller;

import laddarGame.domain.Players;

public class LadderGame {

    private Players players;
    private Ladder ladder;

    public LadderGame(String playerNames, int ladderHeight) {
        this.players = new Players(playerNames);
        this.ladder = new Ladder(ladderHeight);
    }
}
