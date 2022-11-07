package ladder;

import java.util.stream.IntStream;

import ladder.domain.Ladder;
import ladder.domain.Results;
import ladder.domain.User;
import ladder.domain.Users;
import ladder.view.ExecutionResultConsoleView;
import ladder.view.LineConsoleView;
import ladder.view.LineDisplayer;
import ladder.view.ResultConsoleView;
import ladder.view.ResultDisplayer;
import ladder.view.UserConsoleView;
import ladder.view.UserDisplayer;
import ladder.view.UserInput;

public class LadderGameApplication {
    private static final int RESULT_SEARCH_COUNT = 2;
    private static final String ALL_USER_NAME = "all";
    private static final ExecutionResultConsoleView executionView = new ExecutionResultConsoleView();

    public static void main(String[] args) {
        UserInput input = new UserInput();
        Users users = Users.from(input.getUserNames());
        int height = input.getHeight();
        Results results = new Results(users.count(), input.getResult());
        Ladder ladder = Ladder.of(users, height, results);
        
        showUser(users);
        showLadder(users, ladder);
        showResult(users, results);
        showExecutionResult(input, ladder);
    }
    
    private static void showUser(final Users users) {
        new UserConsoleView(new UserDisplayer(users, displaySize(users))).show();
    }

    private static void showLadder(final Users users,  final Ladder ladder) {
        new LineConsoleView(new LineDisplayer(ladder.lines(), displaySize(users))).show();
    }

    private static void showResult(final Users users, final Results results) {
        new ResultConsoleView(new ResultDisplayer(results.getAll(), displaySize(users))).show();
    }

    private static int displaySize(final Users users) {
        return users.getMaxNameSize() + users.names().size();
    }

    private static void showExecutionResult(final UserInput input, final Ladder ladder) {
        IntStream.range(0, RESULT_SEARCH_COUNT).forEach(count -> {
            showExecutionResult(input.getUserName(), ladder);
        });
    }
    
    private static void showExecutionResult(final String userName, final Ladder ladder) {
        if (ALL_USER_NAME.equals(userName)) {
            executionView.show(ladder.getResult());
            return;
        }
        executionView.show(ladder.getResultBy(new User(userName)));
    }
}
