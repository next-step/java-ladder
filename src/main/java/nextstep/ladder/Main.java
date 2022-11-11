package nextstep.ladder;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        Names names = Names.of(InputView.queryNames());
        LadderHeight height = new LadderHeight(InputView.queryHeight());
        Ladder ladder = new Ladder(names, height);

        ResultView.printLadder(ladder);
    }
}
