package ladder.client;

import ladder.controller.PlayLadderGame;

public class LadderGameClient {
    public static void main(String[] args) {
        PlayLadderGame ladderGame = new PlayLadderGame();
        ladderGame.playGame();
    }
}
