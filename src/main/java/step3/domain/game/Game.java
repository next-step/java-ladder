package step3.domain.game;

import step3.domain.ladder.Ladder;

public class Game {
    public static Ladder createLadder(GameData gameData) {
        return gameData.createLadder();
    }
}
