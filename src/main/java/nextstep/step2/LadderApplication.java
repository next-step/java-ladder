package nextstep.step2;

import java.util.Map;

import nextstep.step2.domain.GameResults;
import nextstep.step2.domain.LadderGame;
import nextstep.step2.domain.Player;
import nextstep.step2.domain.Players;
import nextstep.step2.domain.Result;
import nextstep.step2.ui.InputView;
import nextstep.step2.ui.OutputView;

public class LadderApplication {
    private static final String ALL = "all";

    public static void main(String[] args) {
        final var players = Players.create(InputView.inputName().getNames());
        final var gameResults = GameResults.create(InputView.inputResult().getGameResults());
        final var height = InputView.inputLadderHeight();

        LadderGame game = new LadderGame(players, height);

        final var ladder = game.start();
        OutputView.printLadderModel(players, ladder);

        Map<Player, Result> playerResults = players.getPlayerRewards(gameResults, ladder);

        var name = "no";
        while (!ALL.equalsIgnoreCase(name = InputView.inputResultPlayer())) {
            OutputView.printResult(playerResults.get(players.findByName(name)));
        }

        OutputView.printTotalResults(playerResults);
    }

}
