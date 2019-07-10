package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final int WIDTH = 5;
    private static String WHITESPACE_DELIMITER = StringUtil.repeat(" ", WIDTH);
    private static String BAR_DELIMITER = "|";
    private static String DASH_DELIMITER = StringUtil.repeat("-", WIDTH);


    public static void printLadder(Users users, Ladder ladder, Rewards rewards) {
        printUsers(users);
        printEmptyLine();
        printLines(ladder);
        printReward(rewards);
        printEmptyLine();
    }

    public static String convertPointsToString(List<Point> points) {
        return points.stream()
                .map(Output::getLeftDirectionString)
                .collect(Collectors.joining(BAR_DELIMITER, "", BAR_DELIMITER));
    }

    public static String getLeftDirectionString(Point point) {
        if (point.isLeft()) {
            return DASH_DELIMITER;
        }
        return WHITESPACE_DELIMITER;
    }

    public static void printUsers(Users users) {
        users.getUsers().forEach(user -> System.out.print(String.format("%5s ", user.getUserName())));
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLines(Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(Line::getPoints)
                .map(Output::convertPointsToString)
                .forEach(System.out::println);
    }

    public static void printReward(Rewards rewards) {
        rewards.getRewards().forEach(result -> System.out.print(String.format("%5s ", result)));
    }

    public static void printUserReward(String userName, String reward) {
        System.out.println(userName + ": " + reward);
    }

    public static void printResult(LadderResult ladderResult) {
        ladderResult.getUserNames().stream()
                .forEach(userName -> printResultByUserName(ladderResult, userName));
    }

    public static void printResultByUserName(LadderResult ladderResult, String userName) {
        printUserReward(userName, ladderResult.getRewardByUserName(userName));
    }


}
