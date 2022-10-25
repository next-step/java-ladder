package ladder;

import ladder.domain.LadderGame;
import ladder.domain.UserNames;
import ladder.domain.Users;
import ladder.view.ConsoleView;
import ladder.view.UserInput;

public class LadderGameExecutor {
    private static final int MAX_NAME_SIZE = 5;
    
    public static void main(String[] args) {
        UserInput input = new UserInput();
        UserNames names = input.userNames(MAX_NAME_SIZE);
        LadderGame game = new LadderGame(new Users(names), input.height());

        new ConsoleView(names.getAll(), game.execute().lines(), MAX_NAME_SIZE).show();
    }
}
