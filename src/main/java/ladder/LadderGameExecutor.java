package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Users;
import ladder.view.UserInput;

public class LadderGameExecutor {
    public static void main(String[] args) {
        UserInput input = new UserInput();
        LadderGame game = new LadderGame(new Users(input.userNames()), input.height());
    }
}
