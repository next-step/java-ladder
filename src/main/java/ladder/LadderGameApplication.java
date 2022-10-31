package ladder;

import java.util.List;

import ladder.domain.Ladder;
import ladder.view.ConsoleView;
import ladder.view.UserInput;

public class LadderGameApplication {
    private static final int MAX_NAME_SIZE = 5;

    public static void main(String[] args) {
        UserInput input = new UserInput();
        List<String> names = input.getUserNames(MAX_NAME_SIZE);

        Ladder ladder = new Ladder(names.size(), input.getHeight());
        new ConsoleView(names, ladder.lines(), MAX_NAME_SIZE).show();
    }
}
