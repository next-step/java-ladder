package ladder.controller;

import ladder.domain.ExecutionResults;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public void run(){
        Players players = new Players(InputView.enterPlayers());
        ExecutionResults executionResults = new ExecutionResults(players.numberOfPlayer(), InputView.enterExecutionResults());
        Ladder ladder = new Ladder(players.numberOfPlayer(), InputView.enterHeight());
        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printResult(executionResults);

    }
}
