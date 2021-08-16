package step2.domain.game;

import step2.domain.ladder.Ladder;

public class Game {
    public static Ladder createLadder(GameData gameData) {
        return gameData.createLadder();
    }
}
