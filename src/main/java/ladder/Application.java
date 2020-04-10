package ladder;

import ladder.controller.LadderGame;
import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.domain.ResultView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Players players = inputView.inputPlayers();
        Prizes prizes = inputView.inputPrizes(players.count());
        Height height = inputView.inputHeight();

        Ladder ladder = new Ladder(players.count(), height);

        OutputView.printPlayerName(players);
        OutputView.printLadder(ladder);
        OutputView.printPrize(prizes);

        Result result = LadderGame.run(players, ladder, prizes);
        ResultView resultView = new ResultView(result);
        while (true) {
            PlayerName playerName = inputView.inputPlayerName();
            resultView.printResult(playerName);
        }
    }
}
