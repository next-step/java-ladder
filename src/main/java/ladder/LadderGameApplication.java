package ladder;

import java.util.List;

import ladder.domain.Height;
import ladder.domain.LadderGame;
import ladder.domain.Users;
import ladder.view.ConsoleView;
import ladder.view.UserInput;

public class LadderGameApplication {
    private static final int MAX_NAME_SIZE = 5;

    public static void main(String[] args) {
        UserInput input = new UserInput();
        List<String> names = input.getUserNames(MAX_NAME_SIZE);
        LadderGame game = new LadderGame(Users.getInstance(names), new Height(input.getHeight()));

        new ConsoleView(names, game.execute().lines(), MAX_NAME_SIZE).show();
    }
}
