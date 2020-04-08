package ladder;

import ladder.controller.LadderGame;
import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    private static final String ALL = "all";

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Players players = inputView.inputPlayers();
        Prizes prizes = inputView.inputPrizes(players.count());
        Height height = inputView.inputHeight();

        Ladder ladder = new Ladder(players.count(), height);
        Result result = LadderGame.run(players, ladder, prizes);

        OutputView.printPlayerName(players);
        OutputView.printLadder(ladder);
        OutputView.printPrize(prizes);

        PlayerName playerName;
        while (true) {
            playerName = inputView.inputPlayerName();
            if (new PlayerName(ALL).equals(playerName)) {
                break;
            }
            OutputView.printSingleResult(result, playerName);
        }
        OutputView.printAllResult(result);
    }
}
