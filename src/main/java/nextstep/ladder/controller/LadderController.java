package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public void startLadderGame() {
        List<String> players = InputView.inputPlayers();
        List<String> results = InputView.inputResults();
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = new Ladder(new LadderInfo(players.size(), ladderHeight), new RandomPointCreator());
        LadderGame ladderGame = new LadderGame(players, ladder);

        ResultView.printResult(ladderGame);
        ResultView.printLadderResult(results);

        LadderResults ladderResults = ladderGame.climbLadder(results);

        while (true) {
            String playersResults = InputView.inputPlayersResults();
            ResultView.printPlayersResults(playersResults, ladderResults);

            if (playersResults.equals("all")) {
                break;
            }
        }
    }
}
