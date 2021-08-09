package nextstep.ladder.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.PrintLinesDto;
import nextstep.ladder.view.dto.PrintNameWithResultDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;
import nextstep.ladder.view.dto.PrintResultDto;

public class LadderGameController {

    public static void main(final String[] args) {
        final LadderGame game = createLadderGame();

        printLadder(game);
        printResultPlayer(game);
        ResultView.printNameWithResults(game.getPlayerNames().stream()
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
        ResultView.printLadders(new PrintLinesDto(game.getLines().getLines()));
        ResultView.printlnResults(game.getResults().stream()
            .map(PrintResultDto::new)
            .collect(Collectors.toList()));
    }

    private static LadderGame createLadderGame() {
        final List<Name> playerNames = Arrays.stream(InputView.inputPlayerName().split(","))
            .map(Name::of)
            .collect(Collectors.toList());
        final List<Result> results = Arrays.stream(InputView.inputResults().split(","))
            .map(Result::of)
            .collect(Collectors.toList());
        final Lines lines = Lines.of(InputView.inputLadderHeight(), playerNames.size());

        return LadderGame.of(lines, playerNames, results);
    }
}
