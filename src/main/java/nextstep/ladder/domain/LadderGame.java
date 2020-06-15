package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderGame {
    public static void main(String[] argv) {
        List<User> userList = InputView.insertUserLine();

        int height = InputView.insertHeight();

        Ladder ladder = new Ladder(new RandomLadderGenerator(userList.size(), height));

        ResultView.printResult(userList, ladder);
    }
}
