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
    private static final String TWO_SPACE = "  ";
    private static final String FIVE_SPACE = "     ";
    private static final String LINE_WITH_BRIDGE = "-----|";
    private static final String LINE_WITHOUT_BRIDGE = FIVE_SPACE + "|";

    public static void print(Ladder ladder,Users users, Results results) {
        System.out.println(RESULT);
        System.out.println(printUsers(users));
        System.out.println(printLines(ladder.getLines()));
        System.out.println(printResults(results));
    }

    public static void printResults(Results results, Play play, Users users, User user) {
        System.out.println();
        System.out.println(RESULT);
        if (user.isAll()) {
            System.out.println(printMultipleResult(results, users, play));
            return;
        }
        System.out.println(printResult(results.getResult(play.getPosition(users.getUserIndex(user)))));
    }

    private static String printMultipleResult(Results results, Users users, Play play) {
        List<User> user = users.getUsers();

        return IntStream.range(0, user.size())
            .mapToObj(i -> printUser(user.get(i)) + " : " + printResult(results.getResult(play.getPosition(users.getUserIndex(user.get(i))))))
            .collect(Collectors.joining("\n"));
    }

    private static String printResults(Results results) {
        return results.getResult()
            .stream()
            .map(result ->  getSpace(result.getValue().length()) + printResult(result))
            .collect(Collectors.joining());
    }

    private static String printResult(Result result) {
        return result.getValue();
    }

    private static String printUsers(Users users) {
        return users.getUsers().
            stream().
            map(user -> getSpace(user.getName().length()) + printUser(user))
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

    public static String getSpace(int length) {
        if (length < 3) {
            return FIVE_SPACE;
        }
        return TWO_SPACE;
    }
}

