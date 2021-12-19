package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Locale;

import static ladder.domain.Player.PRINT_SIZE;

public class ResultView {

    private static final String EMPTY_FIRST = "    ";
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
            printLoad(point);
        });
        System.out.println();
    }

    private static void printLoad(Point point) {
        Way way = point.getWay();
        System.out.print(way.getLoad());
    }

    public static void printAnswer(Answers answers) {
        answers.getResults().forEach(ResultView::printAnswer);
    }

    private static void printAnswer(String result) {
        int emptySize = PRINT_SIZE - result.length();
        if (emptySize > 0) {
            System.out.print(empty(emptySize) + result);
            return;
        }
        System.out.print(result);
    }

    public static void printResult(Answers answers, Ladder ladder, int index) {
        System.out.println(RESULT);
        System.out.println(answers.getResult(ladder.climb(new Location(index))));
    }

    public static void printResults(Players players, Ladder ladder, Answers answers) {
        System.out.println(RESULT);
        players.getPlayers().forEach(x -> {
            int playerIndex = players.getPlayerIndex(x);
            String result = answers.getResult(ladder.climb(new Location(playerIndex)));
            System.out.println(String.format(RESULTS_FORMAT, x.getName(), result));
        });
    }

    public static boolean isAllResult(String input) {
        return ALL_KEYWORD.equals(input.toLowerCase(Locale.ROOT));
    }

}