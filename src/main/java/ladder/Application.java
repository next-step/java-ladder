package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class Application {
    private static final String ALL_RESULTS = "all";

    public static void main(String[] args) {
        Players players = Players.of(InputView.askPlayers());
        Prizes prizes = Prizes.from(InputView.askPrizes(), players.numberOfPlayers());
        Height height = Height.from(InputView.askHeight());

        Ladder ladder = Ladder.from(players, height);
        OutputView.drawLadder(players, ladder, prizes);

        GameResult gameResult = GameResult.of(players, ladder, prizes);
        String wantedPlayer = InputView.askWhichResultWant();

        if (ALL_RESULTS.equals(wantedPlayer)) {
            OutputView.printAllResult(gameResult);
            return;
        }
        OutputView.printSingleResult(gameResult.findResult(wantedPlayer));
    }
}
