package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;

import java.util.List;

public class ResultView {

    private static final String LADDER_LINE = "|";
    private static final String LADDER_POINT = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String INTERVAL = " ";

    public static void print(Lines lines) {
        printPeople(lines.getPeople());
        printAllLines(lines.getLadderLines());
    }

    private static void printPeople(List<String> people) {
        for (String person : people) {
            System.out.print(person + INTERVAL);
        }
        System.out.println();
    }

    private static void printAllLines(List<Line> lines) {
        for (Line line : lines) {
            printLines(line.getPoints());
            System.out.println();
        }
    }

    private static void printLines(List<Boolean> ladderPoints) {
        for (Boolean ladderPoint : ladderPoints) {
            System.out.print(printPoint(ladderPoint));
        }
        System.out.print(LADDER_LINE);
    }

    private static String printPoint(Boolean point) {
        if (point) {
            return LADDER_LINE + LADDER_POINT;
        }
        return LADDER_LINE + LADDER_EMPTY;
    }
}
