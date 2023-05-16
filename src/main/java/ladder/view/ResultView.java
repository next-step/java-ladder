package ladder.view;

import ladder.model.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LINE = "-----";
    private static final String HEIGHT = "|";
    private static final String EMPTY_LIME = "     ";
    private static final String NEWLINE = "\n";
    private static final String PRINT_ALL = "all";

    private ResultView() {
    }

    public static void showGameResult(List<GameResult> gameResults) {
        while(true) {
            System.out.println(NEWLINE + "결과를 보고 싶은 사람은?");
            String userName = InputView.inputUserName();

            System.out.println(NEWLINE + "실행 결과");
            if (PRINT_ALL.equals(userName)) {
                printAllResult(gameResults);
                return;
            }

            gameResults.stream()
                    .filter(gameResult -> userName.equals(gameResult.getName()))
                    .forEach(gameResult -> System.out.println(gameResult.getReward()));
        }
    }

    private static void printAllResult(List<GameResult> gameResults) {
        gameResults.forEach(gameResult -> {
            System.out.println(gameResult.getName() + " : " + gameResult.getReward());
        });
    }

    public static void showResult(Users users, Ladder ladder, Rewards rewards) {
        System.out.println(NEWLINE + "사다리 결과" + NEWLINE);
        showUsers(users);
        showLadder(ladder);
        showRewards(rewards);
    }

    private static void showUsers(Users users) {
        String printNames = getNames(users).stream()
                .map(name -> String.format("%6s", name))
                .collect(Collectors.joining());

        System.out.println(printNames);
    }

    private static List<String> getNames(Users users) {
        return users.getUsers().stream()
                .map(user -> user.getName().getName())
                .collect(Collectors.toList());
    }

    private static void showLadder(Ladder ladder) {
        ladder.getLines().stream()
                .map(Line::getPoints)
                .forEach(ResultView::showLine);
    }

    private static void showLine(List<Point> points) {
        String line = points.stream()
                .map(ResultView::convertPoint)
                .collect(Collectors.joining(HEIGHT));

        System.out.println(line + HEIGHT);
    }

    private static String convertPoint(Point point) {
        if (point.getLeft()) {
            return LINE;
        }
        return EMPTY_LIME;
    }

    private static void showRewards(Rewards rewards) {
        String printRewards = rewards.getRewards().stream()
                .map(reward -> String.format("%6s", reward.getReward()))
                .collect(Collectors.joining());

        System.out.println(printRewards);
    }
}
