package ladder;

import ladder.domain.Ladder;
import ladder.domain.User;
import ladder.generator.RandomPointGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<User> users = InputView.inputUsers();
        int height = InputView.inputHeight();

        ResultView.printResultInfoMessage();
        ResultView.printUsers(users);
        ResultView.printLadder(Ladder.create(users.size(), height, new RandomPointGenerator()));
    }
}
