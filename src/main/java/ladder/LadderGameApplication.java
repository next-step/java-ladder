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
    
    private final Users users;
    private final Ladder ladder;
    
    public LadderGameApplication(final Users users, final Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    public static void main(String[] args) {
        UserInput input = new UserInput();
        Users users = Users.from(input.getUserNames());
        int height = input.getHeight();
        Results results = new Results(users.count(), input.getResult());

        LadderGameApplication game = new LadderGameApplication(users, Ladder.of(users, height, results));
        show(game, results);
        showExecutionResult(game, input);
    }
    
    private void show(Results results) {
        showUser();
        showLadder();
        showResult(results);
    }

    private void showUser() {
        new UserConsoleView(new UserDisplayer(users, displaySize())).show();
    }

    private void showLadder() {
        new LineConsoleView(new LineDisplayer(ladder.lines(), displaySize())).show();
    }

    private void showResult(final Results results) {
        new ResultConsoleView(new ResultDisplayer(results.getAll(), displaySize())).show();
    }

    private int displaySize() {
        return users.getMaxNameSize() + users.names().size();
    }

    private void showExecutionResult(final String userName) {
        if (ALL_USER_NAME.equals(userName)) {
            executionView.show(ladder.getResult());
            return;
        }
        executionView.show(ladder.getResultBy(new User(userName)));
    }
    
    private static void show(LadderGameApplication game, Results results) {
        game.show(results);
    }
    
    private static void showExecutionResult(final LadderGameApplication game, final UserInput input) {
        IntStream.range(0, RESULT_SEARCH_COUNT).forEach(count -> {
            game.showExecutionResult(input.getUserName());
        });
    }
}
