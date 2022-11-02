package ladder;

import ladder.domain.Ladder;
import ladder.domain.Result;
import ladder.domain.Users;
import ladder.view.ConsoleView;
import ladder.view.UserInput;

public class LadderGameApplication {
    public static void main(String[] args) {
        UserInput input = new UserInput();

        Users users = Users.from(input.getUserNames());
        Result result = new Result(users.count(), input.getResult());
        Ladder ladder = new Ladder(users, input.getHeight(), result);
        new ConsoleView(users, ladder).show();
    }
}
