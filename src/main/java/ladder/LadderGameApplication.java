package ladder;

import ladder.domain.Height;
import ladder.domain.LadderGame;
import ladder.domain.UserNames;
import ladder.domain.Users;
import ladder.view.ConsoleView;
import ladder.view.UserInput;

public class LadderGameApplication {
    private static final int MAX_NAME_SIZE = 5;
    
    public static void main(String[] args) {
        UserInput input = new UserInput();
        UserNames names = new UserNames(input.getUserNames(MAX_NAME_SIZE));
        LadderGame game = new LadderGame(new Users(names), new Height(input.getHeight()));

        new ConsoleView(names.getAll(), game.execute().lines(), MAX_NAME_SIZE).show();
    }
}
