package nextstep.ladder.domain;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.List;

public class LadderGame {
    public static void main(String[] argv) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<User> userList = inputView.insertUserLine();

        int height = inputView.insertHeight();

        Ladder ladder = new Ladder(new RandomLadderGenerator(userList.size(), height));

        resultView.printResult(userList, ladder);
    }
}
