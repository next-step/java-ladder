package step3;

import step3.domain.game.Game;
import step3.domain.game.GameData;
import step3.domain.ladder.Ladder;
import step3.inputView.InputView;
import step3.outputView.OutputView;

public class App {
    public static void main(String[] args) {
        GameData gameData = InputView.makeGameData();
        Ladder ladder = Game.createLadder(gameData);
        OutputView.showLadder(ladder);
    }
}
