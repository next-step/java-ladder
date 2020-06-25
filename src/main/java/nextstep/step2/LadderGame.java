package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.People;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;

public class LadderGame {

    public static void main(String[] args) {
        People people = InputView.inputNames();
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(people.getSize(), height);
        OutputView.draw(ladder, people);
    }
}
