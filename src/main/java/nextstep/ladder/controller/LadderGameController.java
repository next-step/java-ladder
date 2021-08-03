package nextstep.ladder.controller;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    public static void main(String[] args) {
        List<Name> playerNames = InputView.inputPlayerName().stream()
            .map(Name::create)
            .collect(Collectors.toList());
        int ladderHeight = InputView.inputLadderHeight();

        ResultView.printPlayerNames(playerNames.stream()
            .map(Name::getName)
            .collect(Collectors.toList()));
    }
}
