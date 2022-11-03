package ladder;

import ladder.domain.Ladder;
import ladder.domain.Result;
import ladder.domain.Users;
import ladder.view.LineConsoleView;
import ladder.view.LineDisplayer;
import ladder.view.ResultConsoleView;
import ladder.view.ResultDisplayer;
import ladder.view.UserConsoleView;
import ladder.view.UserDisplayer;
import ladder.view.UserInput;

public class LadderGameApplication {
    private static int displaySize;

    public static void main(String[] args) {
        UserInput input = new UserInput();
        
        Users users = Users.from(input.getUserNames());
        Result result = new Result(users.count(), input.getResult());
        Ladder ladder = new Ladder(users, input.getHeight());

        displaySize = users.getMaxNameSize() + users.names().size();
        show(users, result, ladder);
    }

    private static void show(final Users users, final Result result, final Ladder ladder) {
        showUser(users);
        showLadder(ladder);
        showResult(result);
    }

    private static void showUser(final Users users) {
        new UserConsoleView(new UserDisplayer(users, displaySize)).show();
    }

    private static void showLadder(final Ladder ladder) {
        new LineConsoleView(new LineDisplayer(ladder.lines(), displaySize)).show();
    }

    private static void showResult(final Result result) {
        new ResultConsoleView(new ResultDisplayer(result.getAll(), displaySize)).show();
    }
}
