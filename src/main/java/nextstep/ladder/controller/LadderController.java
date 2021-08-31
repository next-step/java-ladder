package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.RandomPointCreator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public void startLadderGame() {
        List<String> players = InputView.inputPlayers();
        List<String> results = InputView.inputResults();

        int ladderHeight = InputView.inputLadderHeight();
        LadderGame ladderGame = new LadderGame(players, ladderHeight, new RandomPointCreator());

        ResultView.printResult(ladderGame);

        String playersResults = InputView.inputPlayersResults();


    }
}
