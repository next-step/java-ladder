package ladder.view;

import ladder.model.*;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String BAR = "|";
    private static final String FIRST_LINE = "    ";
    private static final String EMPTY_LINE = "     ";
    private static final String FULL_LINE = "-----";
    private static final boolean GAME_END = true;
    private static final boolean CONTINUE = false;

    private OutputView() {
    }

    public static void printLadderResult(LadderResult result) {
        printResultMessage();
        printName(result.getUsers());
        printLadder(result.getLadder());
        printResults(result.getResults());
    }

    private static void printResultMessage() {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
    }

    private static void printName(List<User> names) {
        names.forEach(name -> System.out.printf("%5s ", name));
        System.out.println();
    }

    private static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            printLine(line);
            System.out.println();
        }
    }

    private static void printResults(List<Result> results) {
        results.forEach(result -> System.out.printf("%5s ", result));
        System.out.println();
    }

    private static void printLine(Line line) {
        System.out.print(FIRST_LINE);
        System.out.print(BAR);
        List<Direction> directions = line.getDirections();
        for (int i = 0; i < line.size() - 1; i++) {
            printDirection(directions.get(i).isRight());
            System.out.print(BAR);
        }
    }

    private static void printDirection(Boolean isRight) {
        if (isRight) {
            System.out.print(FULL_LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }

    public static boolean printGameResult(GameResult result, String name) {
        System.out.println("실행 결과");
        Map<User, Result> gameResult = result.getGameResult();

        if (name.equals("all")) {
            printAllGameResult(gameResult);
            return GAME_END;
        }

        printOneGameResult(name, gameResult);
        return CONTINUE;
    }

    private static void printAllGameResult(Map<User, Result> gameResult) {
        gameResult.keySet()
                .stream().map(key -> key + " : " + gameResult.get(key))
                .forEach(System.out::println);
    }

    private static void printOneGameResult(String name, Map<User, Result> gameResult) {
        System.out.println(gameResult.get(new User(name)));
    }
}
