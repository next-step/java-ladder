package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Players players = InputView.inputPlayers();
        Results results = InputView.inputResults(players.size());
        Height height = InputView.inputHeight();
        Ladder ladder = new Ladder(players.size(), height.getHeight());

        ResultView.showLadder(ladder, players, results);
        LadderGame ladderGame = new LadderGame(ladder, players.size());
        PlayerResult playerResult = ladderGame.getResult(players, results);
        ResultView.showResult(playerResult);
    }
}
