package ladder.ui;

import ladder.domain.Ladder;
import ladder.domain.UserGenerator;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    public void start() {
        String user = InputView.askNumberOfUser();
        int height = InputView.askLadderHeight();

        UserGenerator userGenerator = new UserGenerator(user);
        Users users = new Users(userGenerator.generateUsers());
        OutputView.printNames(users);

        Ladder ladder = new Ladder(height, users.size());
        OutputView.printLadder(ladder);
    }
}
