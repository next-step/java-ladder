package nextstep.ladder;


import nextstep.ladder.controller.LadderController;
import nextstep.ladder.domain.GameResult;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {

    public static void main(String[] args) {
        String playerNames = InputView.getInputPlayerNames();
        String resultString = InputView.getResults();
        Height laddersHeight = InputView.getLaddersHeight();

        Players players = Players.of(playerNames);
        Results results = Results.of(resultString);
        Ladder ladder = new Ladder(players.size(), laddersHeight);

        System.out.println("\n사다리 결과\n");
        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printResults(results);

        GameResult gameResult = new GameResult(results, ladder);
        LadderController controller = new LadderController(players, gameResult);
        controller.run();
    }

}
