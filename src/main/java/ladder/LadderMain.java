package ladder;

import ladder.domain.GameResult;
import ladder.domain.User;
import ladder.domain.Users;
import ladder.engine.Ladder;
import ladder.engine.LadderCreator;
import ladder.engine.LadderResult;
import ladder.factory.LadderFactory;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Map;

public class LadderMain {
    private static final String SMALL_ALL = "all";
    private static final String BIG_ALL = "ALL";
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Users users = makeUsers(inputView);

        int ladderHeight = inputView.inputLadderHeight();
        Ladder ladder = makeLadder(ladderHeight, users.count());

        LadderResult ladderResult = ladder.play(users);

        String[] inputResult = inputView.inputResults();
        GameResult gameResult = new GameResult(inputResult);

        outputView.printParticipateInUsers(users.userNames());
        outputView.printLadder(ladder.lines());
        outputView.printResult(inputResult);

        String inputShowUserName = inputView.inputShowUserResult();
        showResult(users, gameResult, inputShowUserName, ladderResult);
    }

    private static void showResult(Users users, GameResult gameResult, String inputShowUserName, LadderResult ladderResult) {
        if (isShowAllResult(inputShowUserName)) {
            showAllUserResult(users, gameResult, ladderResult);
        }
        if (!isShowAllResult(inputShowUserName)) {
            showUserResult(users, gameResult, inputShowUserName, ladderResult);
        }
    }

    private static void showUserResult(Users users, GameResult gameResult, String inputShowUserName, LadderResult ladderResult) {
        User user = users.findByName(inputShowUserName);
        int resultPosition = ladderResult.getTarget(user.position());
        String gameResultOfUser = gameResult.show(resultPosition);
        outputView.printUserResult(gameResultOfUser);
    }

    private static void showAllUserResult(Users users, GameResult gameResult, LadderResult ladderResult) {
        Map<String, String> gameResults = gameResult.allResults(users, ladderResult);
        outputView.printUserResults(gameResults);
    }

    private static boolean isShowAllResult(String inputShowUserName) {
        return inputShowUserName.equals(SMALL_ALL) || inputShowUserName.equals(BIG_ALL);
    }

    private static Users makeUsers(InputView inputView) {
        String[] userNames = inputView.inputParticipateInUsers();
        Users users = new Users(userNames);
        users.checkDuplicateUser();
        return users;
    }

    private static Ladder makeLadder(int ladderHeight, int userCount) {
        LadderCreator ladderCreator = LadderFactory.createLadderFactory();
        return ladderCreator.make(ladderHeight, userCount);
    }
}
