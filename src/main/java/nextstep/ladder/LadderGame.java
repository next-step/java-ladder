package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
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

        ResultView.printResultString();
        ResultView.printNames(names);
        ResultView.printLadder(ladder);

        while (true) {
            String playerName = InputView.inputResultPlayerName();
            List<String> result = ladder.play(playerName);
            ResultView.printResult(result);
        }
    }
}
