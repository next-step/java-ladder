package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<String> names = InputView.inputNames();

        Ladder ladder = Ladder.of(
                names,
                Lines.of(names.size(), InputView.inputMaxHeightOfLadder()),
                InputView.inputResult()
        );

        ResultView.printNames(names);
        ResultView.printLadder(ladder);

        LadderResult result = ladder.play();

        String playerName = "";
        while (!"ALL".equalsIgnoreCase(playerName)) {
            playerName = InputView.inputResultPlayerName();
            ResultView.printResult(playerName, result);
        }
    }
}
