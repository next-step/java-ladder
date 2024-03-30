package nextstep.step2;

import nextstep.step2.view.InputView;
import nextstep.step2.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        Humans humans = new Humans(InputView.inputNames());
        int ladderHeight = InputView.inputHeight();
        RandomPointGenerator randomPointGenerator = new RandomPointGenerator();
        Ladder ladder = new Ladder(ladderHeight, humans.getHumanList().size(), randomPointGenerator);
        ResultView.printHumans(humans);
        ResultView.printLadder(ladder);
    }
}
