package ladder_refactor.view;

import ladder_refactor.domain.*;

import java.util.List;
import java.util.Locale;

import static ladder_refactor.domain.Player.PRINT_SIZE;

public class ResultView {

    private static final String EMPTY_FIRST = "    ";
    private static final String NONE_DIRECTION = "     ";
    private static final String DIRECTION = "-----";
    private static final char SPOT = '|';
    private static final String LADDER_RESULT = "\n사다리결과\n";
    private static final String RESULT = "\n실행결과";
    private static final String RESULTS_FORMAT = "%s : %s";
    private static final String ALL_KEYWORD = "all";

    public static void printPlayers(Players players) {
        System.out.println(LADDER_RESULT);
        players.getPlayers()
                .forEach(player -> printPlayer(player.getName()));
        System.out.println();
    }

    private static void printPlayer(String name) {
        int emptySize = PRINT_SIZE - name.length();
        System.out.print(empty(emptySize) + name);
    }

    private static String empty(int emptySize) {
        return new String(new char[emptySize]).replace('\0', ' ');
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> print(line.getPoints()));
    }

    private static void print(List<Point> points) {
        System.out.print(EMPTY_FIRST);
        points.forEach(point -> {
            System.out.print(SPOT);
            printDirection(point);
        });
        System.out.println();
    }

    private static void printDirection(Point point) {
        if (point.getDirection().isRight()) {
            System.out.print(DIRECTION);
            return;
        }
        System.out.print(NONE_DIRECTION);
    }

    public static void printAnswer(Answers answers) {
        answers.getResults().forEach(ResultView::printAnswer);
        System.out.println();
    }

    private static void printAnswer(String result) {
        int emptySize = PRINT_SIZE - result.length();
        if (emptySize > 0) {
            System.out.print(empty(emptySize) + result);
            return;
        }
        System.out.print(result);
    }

    public static void printResult(Answers answers, int climbResultLocation) {
        printResultText();
        System.out.println(answers.getResult(climbResultLocation));
    }

    public static void printResults(Player player, String result) {
        System.out.println(String.format(RESULTS_FORMAT, player.getName(), result));
    }

    public static boolean isAllResult(String input) {
        return ALL_KEYWORD.equals(input.toLowerCase(Locale.ROOT));
    }

    public static void printResultText() {
        System.out.println(RESULT);
    }

}