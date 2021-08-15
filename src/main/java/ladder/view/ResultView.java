package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.ParticipatePeople;

public class ResultView {
    private static final String RESULT_COMMENT = "실행 결과";
    private static final String BLANK = "  ";
    private static final String WITH_POINTS_LINE = "-----|";
    private static final String WITHOUT_POINTS_LINE = "     |";

    public static void printResultComment() {

        System.out.println(RESULT_COMMENT);
    }

    public static void printParticipatePeople(ParticipatePeople participatePeople) {
        participatePeople.getList().stream()
                .forEach(person -> System.out.print(BLANK + person));
        System.out.println();
    }

    public static void drawLadder(Ladder ladder) {
        for (int row = 0; row < ladder.getLadderHeight(); row++) {
            printLine(ladder, row);
            System.out.println();
        }
    }

    private static void printLine(Ladder ladder, int row) {
        for (int column = 0; column < ladder.getLadderWidth(); column++) {
            System.out.print(getLine(ladder, row, column));
        }
    }

    private static String getLine(Ladder ladder, int row, int column) {
        if (ladder.havePoints(row, column)) {
            return WITH_POINTS_LINE;
        }
        return WITHOUT_POINTS_LINE;
    }
}
