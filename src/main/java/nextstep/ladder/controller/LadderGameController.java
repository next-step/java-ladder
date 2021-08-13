package nextstep.ladder.controller;

import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.common.GameResults;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.PrintHorizontalLinesDto;
import nextstep.ladder.view.dto.PrintPlayerDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;
import nextstep.ladder.view.dto.PrintResultsDto;

public class LadderGameController {

    private static final Name PRINT_ALL_NAME_FLAG = Name.of("all");

    public static void main(final String[] args) {
        final LadderGame game = LadderGame.of(
            Players.of(InputView.inputPlayerName()),
            GameResults.of(InputView.inputResults()),
            InputView.inputLadderHeight());

        ResultView.printPlayerNames(new PrintPlayerNamesDto(game.getPlayers()));
        ResultView.printLines(new PrintHorizontalLinesDto(game.getLines()));
        ResultView.printlnResults(new PrintResultsDto(game.getGameResults()));

        Name resultPlayerName = Name.of(InputView.inputResultPlayerName());
        while (!resultPlayerName.equals(PRINT_ALL_NAME_FLAG)) {
            ResultView.printNameWithResult(new PrintPlayerDto(game.getPlayers().getByName(resultPlayerName)));
            resultPlayerName = Name.of(InputView.inputResultPlayerName());
        }

        ResultView.printNameWithResults(
            game.getPlayers().getValues().stream()
                .map(PrintPlayerDto::new)
                .collect(Collectors.toList()));
    }
}
