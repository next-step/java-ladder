package ladder;

import java.util.List;

public class ResultView {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_BLANK_LINE = "     ";
    private static final String HORIZONTAL_FULL_LINE = "-----";

    public static void printResult(UserNames userNames, Ladder ladder) {
        printUserNames(userNames);
        printLadder(ladder);
    }

    private static void printUserNames(UserNames userNames) {
        String blank = " ";
        System.out.println("실행 결과");
        System.out.println();
        userNames.getUserNames().forEach(username -> System.out.printf("%4s", username.getName() + blank));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLadderLines()
            .forEach(ResultView::printLowLine);
    }

    private static void printLowLine(Row row) {
        List<Boolean> points = row.getPoints();
        for (Boolean point : points) {
            printConnectLine(point);
        }
        System.out.println();
    }

    private static void printConnectLine(Boolean point) {
        if (point) {
            System.out.print(HORIZONTAL_FULL_LINE);
            System.out.print(VERTICAL_LINE);
        } else {
            System.out.print(HORIZONTAL_BLANK_LINE);
            System.out.print(VERTICAL_LINE);
        }
    }
}
