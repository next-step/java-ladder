package nextstep.step2;

import nextstep.step2.view.InputView;
import nextstep.step2.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Entries entries = new Entries(InputView.inputNames());
        int ladderHeight = InputView.inputHeight();
        RandomPointGenerator randomPointGenerator = new RandomPointGenerator();
        Ladder ladder = new Ladder(ladderHeight, entries.getHumanList().size(), randomPointGenerator);
        ResultView.printHumans(entries);
        ResultView.printLadder(ladder);
    }
}
