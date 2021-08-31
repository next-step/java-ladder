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

        LadderResults ladderResults = new LadderResults(players, results);

//        Ladder ladder = new Ladder(new LadderInfo(players.size(), ladderHeight), new RandomPointCreator());
        LadderGame ladderGame = new LadderGame(players, ladderHeight, new RandomPointCreator());

        ResultView.printResult(ladderGame);
        ResultView.printLadderResult(results);

        String playersResults = InputView.inputPlayersResults();


        String r = results.get(ladderGame.doLadderGame(0));
        System.out.println(r);
    }
}
