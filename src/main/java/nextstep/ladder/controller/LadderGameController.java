package nextstep.ladder.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.domain.common.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.PrintLinesDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;
import nextstep.ladder.view.dto.PrintResultDto;

public class LadderGameController {

    public static void main(final String[] args) {
        final List<Name> playerNames = createPlayerNames();
        final List<Result> results = createResults();
        final int ladderHeight = InputView.inputLadderHeight();

        final Lines lines = Lines.of(ladderHeight, playerNames.size());

        ResultView.printPlayerNames(new PrintPlayerNamesDto(playerNames));
        ResultView.printLadders(new PrintLinesDto(lines));
        ResultView.printResults(new PrintResultDto(results));

        String resultPlayerName = "";

        while (!resultPlayerName.equals("all")) {
            resultPlayerName = InputView.inputResultPlayerName();
        }
    }

    private static List<Result> createResults() {
        return Arrays.stream(InputView.inputResults().split(","))
            .map(Result::of)
            .collect(Collectors.toList());
    }

    private static List<Name> createPlayerNames() {
        return Arrays.stream(InputView.inputPlayerName().split(","))
            .map(Name::of)
            .collect(Collectors.toList());
    }
}
