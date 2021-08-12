package nextstep.ladder.controller;

import java.util.stream.Collectors;
import nextstep.ladder.domain.HorizontalLines;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.common.GameResults;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.PrintLinesDto;
import nextstep.ladder.view.dto.PrintPlayerDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;
import nextstep.ladder.view.dto.PrintResultsDto;

public class LadderGameController {

    private static final Name PRINT_ALL_NAME_FLAG = Name.of("all");

    public static void main(final String[] args) {
        final LadderGame game = createLadderGame();

        printLadder(game);
        printResultPlayer(game);
        ResultView.printNameWithResults(
            game.getPlayers().getValues().stream()
                .map(PrintPlayerDto::new)
                .collect(Collectors.toList()));
    }

    private static void printResultPlayer(final LadderGame game) {
        Name resultPlayerName = Name.of(InputView.inputResultPlayerName());

        while (!resultPlayerName.equals(PRINT_ALL_NAME_FLAG)) {
            ResultView.printNameWithResult(new PrintPlayerDto(game.getPlayers().getByName(resultPlayerName)));
            resultPlayerName = Name.of(InputView.inputResultPlayerName());
        }
    }

    private static void printLadder(final LadderGame game) {
        ResultView.printPlayerNames(new PrintPlayerNamesDto(game.getPlayers()));
        ResultView.printLadders(new PrintLinesDto(game.getLines()));
        ResultView.printlnResults(new PrintResultsDto(game.getResults()));
    }

    private static LadderGame createLadderGame() {
        final Players players = Players.of((InputView.inputPlayerName()));
        final GameResults gameResults = GameResults.of(InputView.inputResults());
        final HorizontalLines horizontalLines = HorizontalLines.of(InputView.inputLadderHeight(), players.size());

        return LadderGame.of(horizontalLines, players, gameResults);
    }
}
