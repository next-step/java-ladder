package nextstep.ladder.controller;

import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Names;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.domain.common.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.PrintLinesDto;
import nextstep.ladder.view.dto.PrintNameWithResultDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;
import nextstep.ladder.view.dto.PrintResultsDto;

public class LadderGameController {

    public static void main(final String[] args) {
        final LadderGame game = createLadderGame();

        printLadder(game);
        printResultPlayer(game);
        ResultView.printNameWithResults(
            game.getPlayerNames().getValues().stream()
                .map(n -> new PrintNameWithResultDto(n, game.getResult(n)))
                .collect(Collectors.toList()));
    }

    private static void printResultPlayer(final LadderGame game) {
        String resultPlayerName = InputView.inputResultPlayerName();

        while (!resultPlayerName.equals("all")) {
            final Result result = game.getResult(Name.of(resultPlayerName));
            ResultView.printNameWithResult(new PrintNameWithResultDto(Name.of(resultPlayerName), result));
            resultPlayerName = InputView.inputResultPlayerName();
        }
    }

    private static void printLadder(final LadderGame game) {
        ResultView.printPlayerNames(new PrintPlayerNamesDto(game.getPlayerNames()));
        ResultView.printLadders(new PrintLinesDto(game.getLines()));
        ResultView.printlnResults(new PrintResultsDto(game.getResults()));
    }

    private static LadderGame createLadderGame() {
        final Names playerNames = Names.of((InputView.inputPlayerName()));
        final Results results = Results.of(InputView.inputResults());
        final Lines lines = Lines.of(InputView.inputLadderHeight(), playerNames.size());

        return LadderGame.of(lines, playerNames, results);
    }
}
