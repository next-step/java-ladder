package ladder;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.view.ConsoleView;
import ladder.view.UserInput;

public class LadderGameApplication {
    public static void main(String[] args) {
        UserInput input = new UserInput();

        Users users = Users.from(input.getUserNames());
        Ladder ladder = new Ladder(users, input.getHeight());
        new ConsoleView(users, ladder.lines()).show();
    }
}
