package nextstep.ladder.controller;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.view.InputView;

public class LadderGameController {

    public static void main(String[] args) {
        List<Name> playerNames = InputView.inputPlayerName().stream()
            .map(Name::create)
            .collect(Collectors.toList());
    }
}
