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
        LadderGame ladderGame = LadderGame.of(players, ladder);

        ResultView.printResult(ladderGame);
        ResultView.printLadderResult(results);

        LadderResults ladderResults = ladderGame.climbLadder(new Results(results));

        while (true) {
            String whoWantResult = InputView.inputWhoWantResult();
            ResultView.printPlayersResults(whoWantResult, ladderResults);

            if (whoWantResult.equals("all")) {
                break;
            }
        }
    }
}
