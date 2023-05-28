package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        Ladder ladder = new Ladder(inputView.people(), inputView.executeResults(), inputView.height());
        ResultView.printResult(ladder);

        inputView.close();
    }
}
