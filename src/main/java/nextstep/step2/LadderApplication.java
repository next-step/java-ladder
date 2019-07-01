package nextstep.step2;

import nextstep.step2.domain.GameResults;
import nextstep.step2.domain.LadderGame;
import nextstep.step2.domain.Players;
import nextstep.step2.ui.InputView;
import nextstep.step2.ui.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        final var players = Players.create(InputView.inputName().getNames());
        final var gameResults = GameResults.create(InputView.inputResult().getGameResults());
        final var height = InputView.inputLadderHeight();

        LadderGame game = new LadderGame(players, height);

        final var result = game.start();
        OutputView.printLadderModel(players, result);
    }

}
