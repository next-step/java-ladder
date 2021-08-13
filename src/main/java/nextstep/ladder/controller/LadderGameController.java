package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.common.GameResults;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    private static final Name PRINT_ALL_NAME_FLAG = Name.of("all");

    public static void main(final String[] args) {
        final LadderGame game = LadderGame.of(
            Players.of(InputView.inputPlayerName()),
            GameResults.of(InputView.inputResults()),
            InputView.inputLadderHeight());

        printLadder(game);
        printResult(game);
    }

    private static void printResult(final LadderGame game) {
        Name playerName = Name.of(InputView.inputResultPlayerName());
        while (!playerName.equals(PRINT_ALL_NAME_FLAG)) {
            ResultView.printNameWithResult(game.getPlayerDto(playerName));
            playerName = Name.of(InputView.inputResultPlayerName());
        }

        ResultView.printNameWithResults(game.getPlayersDto());
    }

    private static void printLadder(final LadderGame game) {
        ResultView.printPlayerNames(game.getPlayersDto());
        ResultView.printLines(game.getLinesDto());
        ResultView.printlnResults(game.getGameResultsDto());
    }
}
