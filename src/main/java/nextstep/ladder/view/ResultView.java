package nextstep.ladder.view;

import nextstep.ladder.domain.LadderBoard;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.UserNames;

public class ResultView {
    private final static String GAP = "     ";
    private final static String LINE = "-----";
    private final static String LADDER = "|";
    private final static String LADDER_FORMAT = "%6s";


    public static void printNames(UserNames userNames) {
        userNames.getNames().stream().map(name -> String.format(LADDER_FORMAT, name)).forEach(System.out::print);
        System.out.println();
    }

    public static void printLadderBoard(LadderBoard ladderBoard) {
        ladderBoard.getLadderBoard().forEach(line -> {
            printGap(false);
            printRow(line);
            printLadder();
            System.out.println();
        });
    }

    private static void printRow(Line line) {
        line.pointToBoolean().forEach(point -> {
            printLadder();
            printLine(point);
            printGap(point);
        });
    }

    private static void printLadder() {
        System.out.print(LADDER);
    }

    private static void printLine(Boolean point) {
        if(point) {
            System.out.print(LINE);
        }
    }

    private static void printGap(Boolean point) {
        if(!point) {
            System.out.print(GAP);
        }
    }

}
