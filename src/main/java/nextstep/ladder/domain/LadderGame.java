package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {
    public static void main(String[] argv) {
        Users users = InputView.insertUserLine();

        int height = InputView.insertHeight();

        Ladder ladder = new Ladder(new RandomLadderGenerator(users.size(), height));

        ResultView.printResult(users, ladder);
    }
}
