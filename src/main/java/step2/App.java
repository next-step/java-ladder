package step2;

import step2.domain.game.Game;
import step2.domain.game.GameData;
import step2.domain.ladder.Ladder;
import step2.inputView.InputView;
import step2.outputView.OutputView;

public class App {
    public static void main(String[] args) {
        GameData gameData = InputView.makeGameData();
        Ladder ladder = Game.createLadder(gameData);
        OutputView.showLadder(ladder);
    }
}
