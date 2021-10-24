package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderMain {
    private static final String SMALL_ALL = "all";
    private static final String BIG_ALL = "ALL";
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Users users = makeUsers(inputView);
        int ladderHeight = inputView.inputLadderHeight();

        HeeSeokLadder heeSeokLadder = makeLadder(inputView, users.count());

        String[] inputResult = inputView.inputResults();
        GameResult gameResult = new GameResult(inputResult);

//        LadderGame ladderGame = new LadderGame(users, heeSeokLadder.lines());
        //users = ladderGame.start();

        outputView.printParticipateInUsers(users.userNames());
        outputView.printLadder(heeSeokLadder.lines());
        outputView.printResult(inputResult);

        String inputShowUserName = inputView.inputShowUserResult();
        showResult(users, gameResult, inputShowUserName);
    }

    private static void showResult(Users users, GameResult gameResult, String inputShowUserName) {
        if (isShowAllResult(inputShowUserName)) {
            showAllUserResult(users, gameResult);
        }
        if (!isShowAllResult(inputShowUserName)) {
            showUserResult(users, gameResult, inputShowUserName);
        }
    }

    private static void showAllUserResult(Users users, GameResult gameResult) {
        Map<String, String> gameResults = gameResult.allResults(users);
        outputView.printUserResults(gameResults);
    }

    private static void showUserResult(Users users, GameResult gameResult, String inputShowUserName) {
        User user = users.findByName(inputShowUserName);
        int userPosition = user.position();
        String gameResultOfUser = gameResult.show(userPosition);
        outputView.printUserResult(gameResultOfUser);
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

    private static HeeSeokLadder makeLadder(InputView inputView, int userCount) {
        int ladderHeight = inputView.inputLadderHeight();
        List<Line> lineList = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            Line newLine = new Line(userCount);
            newLine.drawOneLine();
            lineList.add(newLine);
        }
        Lines lines = new Lines(lineList);
        return new HeeSeokLadder(lines);
    }
}
