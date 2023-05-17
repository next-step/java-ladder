package ladder.View;

import ladder.Model.LadderLine;
import ladder.Model.Ladder;

import java.util.List;

public class ResultView {
    private static final int PRINT_WIDTH = 5;
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZON_LINE = "-".repeat(PRINT_WIDTH);
    private static final String HORIZON_NO_LINE = " ".repeat(PRINT_WIDTH);

    public static void printResultHeader() {
        System.out.println("");
        System.out.println("실행결과");
        System.out.println("");
    }

    public static void printResultBody(List<String> attendances, Ladder ladder) {
        printAttendances(attendances);
        printLadder(ladder);
    }

    private static void printAttendances(List<String> attendances) {
        attendances.forEach(s -> {
            System.out.print(" ".repeat(PRINT_WIDTH + 1 - s.length()));
            System.out.print(s);
        });
        System.out.println("");
    }

    private static void printLadder(Ladder ladder) {
        ladder.ladderLines().forEach(ResultView::printLadderLine);
    }

    private static void printLadderLine(LadderLine ladderLine) {
        printLadderHorizonLine(false);
        System.out.print(VERTICAL_LINE);

        ladderLine.lines().forEach(
                b -> {
                    printLadderHorizonLine(b);
                    System.out.print(VERTICAL_LINE);
                }
        );

        System.out.println("");
    }

    private static void printLadderHorizonLine(Boolean exist) {
        if (exist) {
            System.out.print(HORIZON_LINE);
            return;
        }

        System.out.print(HORIZON_NO_LINE);
    }
}
