package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    private static final String ALL_RESULTS = "all";

    public static void main(String[] args) {
        Players players = Players.of(InputView.askPlayers());
        Prizes prizes = Prizes.from(InputView.askPrizes());
        GameInfo gameInfo = GameInfo.of(players, prizes);

        Height height = Height.from(InputView.askHeight());

        Ladder ladder = Ladder.from(players, height);
        OutputView.drawLadder(ladder, gameInfo);

        GameResult gameResult = GameResult.of(ladder, gameInfo);
        String wantedPlayer = InputView.askWhichResultWant();

        if (ALL_RESULTS.equals(wantedPlayer)) {
            OutputView.printAllResult(gameResult);
            return;
        }
        OutputView.printSingleResult(gameResult.findResult(wantedPlayer));
    }
}
