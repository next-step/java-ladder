package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Players;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String RESULT = "실행결과";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY = "     ";

    public static void printResult(Ladder ladder, Players players) {
        System.out.println();
        System.out.println(RESULT);
        printPlayer(players.get());
        printLadder(ladder.get());
    }

    private static void printPlayer(String[] players) {
        Arrays.stream(players)
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
}
