package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        Results results = InputView.inputResults(players.size());
        Height height = InputView.inputHeight();
        MoveStrategy moveStrategy = new DirectionMoveStrategy();
        LadderGame ladderGame = new LadderGame(players.size(), height.getHeight(), moveStrategy);
        ResultView.showLadder(ladderGame.getLadder(), players, results);

        PlayerResult playerResult = new PlayerResult(players, results, ladderGame.getPosition());
        ResultView.showResult(playerResult);
    }
}
