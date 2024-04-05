package nextstep.ladder;

import java.util.List;

public class ResultView {
    private final static String GAP = "     ";
    private final static String LINE = "-----";
    private final static String LADDER = "|";
    private final static String LADDER_FORMAT = "%6s";


    public static void printNames(List<String> names) {
        names.stream().map(name -> String.format(LADDER_FORMAT, name)).forEach(System.out::print);
        System.out.println();
    }

    public static void printLadderBoard(LadderBoard ladderBoard) {
        ladderBoard.getLadderBoard().forEach(line -> {
            printGap();
            line.getPoints().forEach(point -> {
                printLadder();
                if (point.isPoint()) {
                    printLine();
                } else {
                    printGap();
                }
            });
            printLadder();
            System.out.println();
        });
    }

    private static void printLadder() {
        System.out.print(LADDER);
    }

    private static void printLine() {
        System.out.print(LINE);
    }

    private static void printGap() {
        System.out.print(GAP);
    }

}
