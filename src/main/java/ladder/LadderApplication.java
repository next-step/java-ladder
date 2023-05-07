package ladder;

import ladder.model.Ladder;
import ladder.model.Users;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;


public class LadderApplication {
    public static void main(String[] args) {
        List<String> userNames = InputView.inputUserNames();
        int ladderSize = InputView.inputLadderSize();

        Users users = Users.of(userNames);
        Ladder ladder = Ladder.of(users.size(), ladderSize);

        ResultView.showResult(users, ladder);
    }
}
