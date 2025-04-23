package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    public void run() {
        String inputNames = InputView.inputPlayerNames();
        String inputResults = InputView.inputResults();
        int height = InputView.inputLadderHeight();

        Players players = new Players(inputNames);
        Ladder ladder = new Ladder(height, players.size());
        Results results = new Results(players.getPlayersName(), inputResults);

        ResultView.printLadderResultMessage();
        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printResults(results);

        while(true) {
            String name = InputView.inputPlayerNameToCheckResult();
            if(name.equalsIgnoreCase("exit")){
                return;
            }

            if (name.equalsIgnoreCase("all")) {
                ResultView.printAllResults(results.getResultsByName());
            } else {
                Result result = results.findByName(name);
                ResultView.printSingleResult(result.getResult());
            }
        }
    }

    public static void main(String[] args) {
        new LadderGameController().run();
    }
}
