package ladder;

import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.result.LadderResult;
import ladder.domain.strategy.RandomLineStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        Players players = Players.of(inputView.inputPlayers());
        LadderResult ladderResult = LadderResult.of(inputView.inputResult());
        int height = inputView.inputHeight();
        Ladder ladder = Ladder.of(players.getCountOfPerson(), height, new RandomLineStrategy());
        resultView.printLadder(players, ladder, ladderResult);
        LadderGame ladderGame = new LadderGame(ladder);
        ladderGame.findAllPosition(players.getCountOfPerson()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        new LadderController().run();
    }
}
