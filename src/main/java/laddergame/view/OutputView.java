package laddergame.view;

import laddergame.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static laddergame.domain.Name.MAX_NAME_LENGTH;

public class OutputView {
    public static final String LADDER_WITH_HORIZONTAL_LINE = "-----|";
    public static final String LADDER_WITHOUT_HORIZONTAL_LINE = "     |";

    public static void printGameMap(List<Name> userNames, List<String> results, Ladder ladder) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println(makeNameString(userNames));
        ladder.getPoints().stream()
                .map(line -> makeLineString(line))
                .forEach(System.out::println);
        System.out.println(makeResultString(results));
        System.out.println();
    }

    private static String makeNameString(List<Name> userNames) {
        return userNames.stream()
                .map(name -> " ".repeat(1 + MAX_NAME_LENGTH - name.getName().length()) + name.getName())
                .collect(Collectors.joining());
    }

    private static String makeResultString(List<String> results) {
        return results.stream()
                .map(result -> " ".repeat(1 + MAX_NAME_LENGTH - result.length()) + result)
                .collect(Collectors.joining());
    }

    private static String makeLineString(Line line) {
        return line.getLine().stream()
                .map(point -> {
                    if (point.equals(new Point(true))) {
                        return LADDER_WITH_HORIZONTAL_LINE;
                    }
                    return LADDER_WITHOUT_HORIZONTAL_LINE;
                })
                .collect(Collectors.joining());
    }

    public static void printResult(Map<User, String> gameResult) {
        System.out.println("실행 결과");
        for (Map.Entry<User, String> result: gameResult.entrySet()) {
            System.out.println(result.getKey().getName().getName() + " : " + result.getValue());
        }
        System.out.println();
    }
}
