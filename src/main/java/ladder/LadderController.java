package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGame;
import ladder.domain.player.Players;
import ladder.domain.result.LadderResults;
import ladder.domain.result.MatchResult;
import ladder.domain.strategy.RandomLineStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        Players players = Players.of(inputView.inputPlayers());
        LadderResults ladderResults = LadderResults.of(inputView.inputResult(), players);
        int height = inputView.inputHeight();
        Ladder ladder = Ladder.of(players.getCountOfPerson(), height, new RandomLineStrategy());
        resultView.printLadder(players, ladder, ladderResults);
        MatchResult matchResult = new LadderGame(ladder).findAllPosition(players, ladderResults);
        String name = "";
        while (!name.equals(ResultView.ALL)) {
            name = inputView.inputName();
            resultView.printGameResult(name, players, matchResult);
        }
    }

    public static void main(String[] args) {
        new LadderController().run();
    }
}
