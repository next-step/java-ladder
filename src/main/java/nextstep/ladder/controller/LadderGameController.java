package nextstep.ladder.controller;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    public static void main(String[] args) {
        List<Name> playerNames = createPlayerNames();
        int ladderHeight = InputView.inputLadderHeight();

        Lines lines = Lines.of(ladderHeight, playerNames.size());

        ResultView.printPlayerNames(createPrintPlayerNamesDto(playerNames));
        ResultView.printLadders(lines);
    }

    private static List<String> createPrintPlayerNamesDto(List<Name> playerNames) {
        return playerNames.stream()
            .map(Name::getName)
            .collect(Collectors.toList());
    }

    private static List<Name> createPlayerNames() {
        return InputView.inputPlayerName().stream()
            .map(Name::create)
            .collect(Collectors.toList());
    }
}
