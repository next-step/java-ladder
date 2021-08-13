package nextstep.ladder.controller;

import nextstep.ladder.domain.HorizontalLines;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.common.GameResults;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.PrintHorizontalLinesDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;
import nextstep.ladder.view.dto.PrintResultsDto;

public class LadderGameController {

    private static final Name PRINT_ALL_NAME_FLAG = Name.of("all");

    public static void main(final String[] args) {
        final Players players = Players.of(InputView.inputPlayerName());
        final GameResults gameResults = GameResults.of(InputView.inputResults());
        final HorizontalLines lines = HorizontalLines.of(InputView.inputLadderHeight(), players.size());

        for (int i = 0; i < players.getValues().size(); i++) {
            players.updateResult(i, gameResults.get(lines.move(i)));
        }

        System.out.println();

        ResultView.printPlayerNames(new PrintPlayerNamesDto(players));
        ResultView.printLines(new PrintHorizontalLinesDto(lines));
        ResultView.printlnResults(new PrintResultsDto(gameResults));
    }
}
