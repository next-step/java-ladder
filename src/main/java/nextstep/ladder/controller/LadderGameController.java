package nextstep.ladder.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.PrintLinesDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;

public class LadderGameController {

    public static void main(String[] args) {
        final List<Name> playerNames = createPlayerNames();
        final int ladderHeight = InputView.inputLadderHeight();

        final Lines lines = Lines.of(ladderHeight, playerNames.size());

        ResultView.printPlayerNames(new PrintPlayerNamesDto(playerNames));
        ResultView.printLadders(new PrintLinesDto(lines));
    }

    private static List<Name> createPlayerNames() {
        final String playerNames = InputView.inputPlayerName();

        return Arrays.stream(playerNames.split(","))
            .map(Name::of)
            .collect(Collectors.toList());
    }
}
