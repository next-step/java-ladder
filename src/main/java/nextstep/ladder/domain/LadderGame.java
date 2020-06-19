package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {
    public static void main(String[] argv) {
        Users users = InputView.insertUserLine();

        Ladder ladder = new Ladder(new RandomLadderGenerator(users.size(), InputView.getHeight()));

        ResultView.printResult(users, ladder);
    }
}
