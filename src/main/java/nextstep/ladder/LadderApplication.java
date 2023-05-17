package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderApplication {

    public static void main(String[] args) {

        List<String> names = InputView.inputUserNames();
        Users users = new Users(names);

        int height = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(users.getUsers().size(), height);

        OutputView.afterGame();
        OutputView.display(users, ladder);
    }
}
