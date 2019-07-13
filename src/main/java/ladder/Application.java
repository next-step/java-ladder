package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    private static final String ALL_RESULTS = "all";

    public static void main(String[] args) {
        Players players = Players.of(InputView.askPlayers());
        Prizes prizes = Prizes.from(InputView.askPrizes());
        Height height = Height.from(InputView.askHeight());

        GameInfo gameInfo = GameInfo.of(players, prizes);
        Ladder ladder = Ladder.from(players.numberOfPlayers(), height);

        LadderGame ladderGame = LadderGame.of(gameInfo, ladder);
        GameResult gameResult = ladderGame.playGame();

        OutputView.printGame(ladderGame);

        String wantedPlayer = InputView.askWhichResultWant();
        if (ALL_RESULTS.equals(wantedPlayer)) {
            OutputView.printAllResult(gameResult);
            return;
        }
        OutputView.printSingleResult(gameResult.findResult(wantedPlayer));
    }
}
