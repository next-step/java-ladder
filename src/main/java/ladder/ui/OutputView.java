package ladder.ui;

import ladder.domain.*;
import ladder.dto.UserResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class OutputView {

    private static final String LADDER_WITH_NO_SPACE = " ";
    private static final String HORIZONTAL_UNIT = "-";
    private static final String VERTICAL_UNIT = "|";
    private static final String PLAY_RESULT_MSG = "실행 결과";
    private static final int ADDITIONAL_SPACE = 1;

    public static void printLadder(Users users, Ladder ladder, LadderResult ladderResult) {
        int maxInterval = findMaxInterval(users, ladderResult);
        List<UserResult> userResults = getUserResults(users, ladderResult);
        printName(userResults, maxInterval);
        System.out.println();
        printLine(ladder, maxInterval);
        printResult(userResults, maxInterval);
        System.out.println();
    }

    private static List<UserResult> getUserResults(Users users, LadderResult ladderResult) {
        return IntStream.range(0, users.size())
                .mapToObj(Position::new)
                .map((position -> {
                    User user = users.findUserByPosition(position);
                    Result result = ladderResult.findResultByPosition(position);
                    return new UserResult(user, result);
                }))
                .collect(Collectors.toList());
    }

    private static int findMaxInterval(Users users, LadderResult ladderResult) {
        int maxInterval = -1;
        for (int i = 0; i < users.size(); i++) {
            Position position = new Position(i);
            User user = users.findUserByPosition(position);
            Result result = ladderResult.findResultByPosition(position);
            maxInterval = Math.max(getMaxLength(user, result), maxInterval);
        }
        return maxInterval + ADDITIONAL_SPACE;
    }

    private static int getMaxLength(User user, Result result) {
        return user.maxLength(result.getResult());
    }

    private static void printName(List<UserResult> userResults, int maxInterval) {
        userResults.stream()
                .map((UserResult::getUser))
                .forEach((user) -> {
                    String name = getUsername(user);
                    System.out.print(addDelimiter(maxInterval - name.length(), LADDER_WITH_NO_SPACE) + name);
                });
    }

    private static void printLine(Ladder ladder, int maxInterval) {
        List<VerticalLine> lines = ladder.getLines();
        for (int lengthIndex = 0; lengthIndex < ladder.getLadderLength().getLength(); lengthIndex++) {
            printSingleLine(maxInterval, lines, lengthIndex);
            System.out.println();
        }
    }

    private static void printSingleLine(int maxInterval, List<VerticalLine> lines, int lengthIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            Direction unit = lines.get(lineIndex).getLineUnits().get(lengthIndex);
            appendSingleLine(maxInterval, stringBuilder, unit);
        }
        System.out.print(stringBuilder);
    }


    private static void appendSingleLine(int maxInterval, StringBuilder stringBuilder, Direction unit) {
        if (unit.hasPrevious()) {
            stringBuilder.append(addDelimiter(maxInterval - 1, HORIZONTAL_UNIT) + VERTICAL_UNIT);
            return;
        }
        stringBuilder.append(addDelimiter(maxInterval - 1, LADDER_WITH_NO_SPACE) + VERTICAL_UNIT);
    }

    private static void printResult(List<UserResult> userResults, int maxInterval) {
        userResults.stream()
                .map(UserResult::getResult)
                .forEach((result) -> {
                    String singleResult = result.getResult();
                    System.out.print(addDelimiter(maxInterval - singleResult.length(), LADDER_WITH_NO_SPACE) + singleResult);
                });
    }

    private static String addDelimiter(int length, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(delimiter);
        }
        return stringBuilder.toString();
    }

    public static void printResult(List<UserResult> userResults) {
        System.out.println(PLAY_RESULT_MSG);
        IntStream.range(0, userResults.size())
                .forEach((idx) -> {
                    UserResult userResult = userResults.get(idx);
                    System.out.printf("%s : %s \n", getUsername(userResult.getUser()), getResult(userResult.getResult()));
                });
    }

    private static String getUsername(User user) {
        return user.getName();
    }

    private static String getResult(Result result) {
        return result.getResult();
    }

}
