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
        Ladder ladder = Ladder.from(users, height);
        ResultView.print(ladder, users, results);

        Play play = new Play(ladder, users, results);
        User user;

        do {
            user = InputView.inputResultUser();
            ResultView.printResults(play, user);
        } while (!user.isAll());
    }
}
