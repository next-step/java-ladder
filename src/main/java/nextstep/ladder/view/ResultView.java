package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author han
 */
public class ResultView {
    private static final String RESULT = "실행결과";
    private static final String THREE_SPACE = "   ";
    private static final String FIVE_SPACE = "     ";
    private static final String LINE_WITH_BRIDGE = "-----|";
    private static final String LINE_WITHOUT_BRIDGE = FIVE_SPACE + "|";

    public static void print(Ladder ladder) {
        System.out.println(RESULT);
        System.out.println(printUsers(ladder.getUsers()));
        System.out.println(printLines(ladder.getLines()));
        System.out.println(printResults(ladder.getResults()));
    }

    public static void printResults(Ladder ladder, User user) {
        System.out.println(RESULT);
        if (user.isAll()) {
            System.out.println(printMultipleResult(ladder));
            return;
        }
        System.out.println(printResults(ladder.getResultsBy(user)));
    }

    private static String printMultipleResult(Ladder ladder) {
        List<User> users = ladder.getUsers().getUsers();
        List<Result> result = ladder.getResults().getResult();

        return IntStream.range(0, users.size())
            .mapToObj(i -> printUser(users.get(i)) + ":" + printResult(result.get(i)))
            .collect(Collectors.joining("\n"));
    }


    private static String printResults(Results results) {
        return results.getResult()
            .stream()
            .map(result -> printResult(result) + THREE_SPACE)
            .collect(Collectors.joining());
    }

    private static String printResult(Result result) {
        return result.getValue();
    }

    private static String printUsers(Users users) {
        return users.getUsers().
            stream().
            map(user -> printUser(user) + THREE_SPACE)
            .collect(Collectors.joining());
    }

    private static String printUser(User user) {
        return user.getName();
    }

    private static String printLines(Lines lines) {
        return lines.getLines().
            stream()
            .map(line -> printLine(line))
            .collect(Collectors.joining("\n"));
    }

    private static String printLine(Line line) {
        return line.getPoints()
            .stream()
            .map(point -> printPoint(point))
            .collect(Collectors.joining());
    }

    private static String printPoint(Point point) {
        if (point.hasLineBefore()) {
            return LINE_WITH_BRIDGE;
        }
        return LINE_WITHOUT_BRIDGE;
    }
}

