package ladder;

import java.util.Map;
import ladder.domain.Ladder;
import ladder.domain.RandomLineStrategy;
import ladder.domain.Results;
import ladder.domain.User;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    private static final String ALL = "all";

    public static void main(String[] args) {
        Users users = new Users(InputView.enterNames());
        Results results = Results.create(InputView.enterResult(), users.count());
        int height = InputView.enterHeight();

        Ladder ladder = Ladder.create(users.count(), height, new RandomLineStrategy());
        OutputView.outputLadder(ladder, users, results);

        Map<User, String> gameResult = ladder.execute(users, results);

        while (true) {
            User user = new User(InputView.enterUserToGetResult());
            OutputView.outputUsersWithResults(user, gameResult);
            if (user.getName().equals(ALL)){
                return;
            }
        }

    }


}
