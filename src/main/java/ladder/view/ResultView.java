package ladder.view;

import ladder.domain.*;

import java.util.List;

public class ResultView {
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY = "     ";
    private static final String GAME_RESULT = "실행 결과";

    public static void printLadderResult(Ladder ladder, Players players, Results results) {
        System.out.println();
        System.out.println(LADDER_RESULT);
        printPlayer(players.get());
        printLadder(ladder.get());
        printResults(results.get());
    }

    public static void printGameResult(List<LadderResult> results) {
        System.out.println();
        System.out.println(GAME_RESULT);
        if (results.size() == 1) {
            System.out.println(results.get(0).getResult());
            return;
        }

        results.stream()
                .forEach((ladderResult) -> System.out.printf("%s : %s\n", ladderResult.getPlayer(), ladderResult.getResult()));
    }

    private static void printPlayer(List<Name> players) {
        players.stream()
                .forEach(player -> System.out.print(String.format("%-5s ", player)));
        System.out.println();
    }

    private static void printLadder(List<Line> ladder) {
        ladder.stream()
                .forEach(line -> printLine(line));
    }

    private static void printLine(Line line) {
        for (int i = 0; i < line.numberOfPoints(); i++) {
            System.out.print(VERTICAL_LINE);
            printRightLine(line, i);
        }
        System.out.println();
    }

    private static void printRightLine(Line line, int point) {
        if (line.hasRightLine(point)) {
            System.out.print(HORIZONTAL_LINE);
            return;
        }
        System.out.print(EMPTY);
    }

    private static void printResults(List<String> results) {
        results.stream()
                .forEach(result -> System.out.print(String.format("%-5s ", result)));
        System.out.println();
    }

}
