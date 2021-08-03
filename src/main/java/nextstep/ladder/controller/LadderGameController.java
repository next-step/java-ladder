package nextstep.ladder.controller;

import java.util.List;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.PrintLinesDto;
import nextstep.ladder.view.dto.PrintPlayerNamesDto;

public class LadderGameController {

    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayerName();
        int ladderHeight = InputView.inputLadderHeight();

        Lines lines = Lines.of(ladderHeight, playerNames.size());

        ResultView.printPlayerNames(new PrintPlayerNamesDto(Name.of(playerNames)));
        ResultView.printLadders(new PrintLinesDto(lines));
    }
}
