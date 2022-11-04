package ladder;

import java.util.List;
import java.util.stream.IntStream;

import ladder.domain.ExecutionResult;
import ladder.domain.Ladder;
import ladder.domain.Results;
import ladder.domain.User;
import ladder.domain.Users;
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
    
    public static void main(String[] args) {
        UserInput input = new UserInput();
        
        Users users = Users.from(input.getUserNames());
        
        int height = input.getHeight();
        Results results = new Results(users.count(), input.getResult());
        Ladder ladder = Ladder.of(users, height, results);

        int displaySize = users.getMaxNameSize() + users.names().size();
        showUser(users, displaySize);
        showLadder(ladder, displaySize);
        showResult(results, displaySize);
        showResultBy(ladder, input);
    }

    private static void showResultBy(final Ladder ladder, UserInput input) {
        IntStream.range(0, RESULT_SEARCH_COUNT).forEach(count -> {
            showResult(ladder, input.getUserName());
        });
    }

    private static void showUser(final Users users, final int displaySize) {
        new UserConsoleView(new UserDisplayer(users, displaySize)).show();
    }

    private static void showLadder(final Ladder ladder, final int displaySize) {
        new LineConsoleView(new LineDisplayer(ladder.lines(), displaySize)).show();
    }

    private static void showResult(final Results results, final int displaySize) {
        new ResultConsoleView(new ResultDisplayer(results.getAll(), displaySize)).show();
    }

    private static void showResult(Ladder ladder, String userName) {
        System.out.println("실행 결과");
        if (ALL_USER_NAME == userName) {
            showResult(ladder.getResult());
        }
        showResult(ladder.getResultBy(new User(userName)));
    }

    private static void showResult(List<ExecutionResult> result) {
        result.forEach(it -> showResult(it));
    }

    private static void showResult(ExecutionResult result) {
        System.out.println(result.userName() + " : " + result.name());
    }
}
