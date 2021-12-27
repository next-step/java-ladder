package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

/**
 * @author han
 */
public class Main {

    public static void main(String[] args) {

        Users users = InputView.inputUserNames();
        Results results = InputView.inputResults();
        Height height = InputView.inputLadderHeight();
        Ladder ladder = Ladder.from(users, height, results);
        ResultView.print(ladder);

        User user = InputView.inputResultUser();
        ResultView.printResults(ladder, user);
    }
}
