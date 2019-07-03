package ladder;

import java.util.StringJoiner;

public class ResultView {
    private static final String LINE_FORMAT = "-----";
    private static final String BLANK_FORMAT = "     ";
    private static final String POLE_FORMAT = "|";


    public static void printResult(LadderGame ladderGame) {
        System.out.println("실행결과");
        for (String name : ladderGame.getPlayers()) {
            System.out.print(String.format("%5s ", name));
        }
        System.out.println();
        printLadder(ladderGame.getLadder());
    }

    private static void printLadder(Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadder()) {
            printLine(ladderLine);
        }
    }

    private static void printLine(LadderLine ladderLine) {
        StringJoiner sb = new StringJoiner("|");
        for (Boolean point : ladderLine.getLadderLine()) {
            sb.add(printPoint(point));
        }
        System.out.println(POLE_FORMAT + sb.toString() + POLE_FORMAT);
    }

    private static String printPoint(Boolean point) {
        return point ? LINE_FORMAT : BLANK_FORMAT;
    }
}
