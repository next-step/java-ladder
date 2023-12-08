package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        int maxHeightOfLadder = InputView.inputMaxHeightOfLadder();

        Ladder ladder = Ladder.of(names, maxHeightOfLadder, List.of());

        ResultView.printResultString();
        ResultView.printNames(names);
        ResultView.printLadder(ladder);
    }
}
