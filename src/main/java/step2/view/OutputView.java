package step2.view;

import step2.model.*;

public class OutputView {

    private static final String INITIAL_LINE = "    |";
    private static final String RUNG_CONDITION_TRUE = "-----|";
    private static final String RUNG_CONDITION_FALSE = "     |";

    public static void printAll(Participants participants, Ladder ladderGame, PrizeLocation prizeLocation) {
        Banner();
        printNameList(participants);
        printLadder(ladderGame);
        printPrizeList(prizeLocation);
        //askTheResultofPerson();
    }

    private static void printPrizeList(PrizeLocation prizeLocation) {
        System.out.println(prizeLocation.toString());
    }

    private static void askTheResultofPerson() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public static void Banner() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printNameList(Participants participants) {
        System.out.println(participants.toString());
    }

    public static void printLadder(Ladder ladder) {
        int height = ladder.getHeightOfLadder();
        for (int loop = 0; loop < height; loop++) {
            printLine(ladder.getLineOfHeight(loop));
        }
    }

    private static void printLine(Line line) {
        StringBuffer lineView = new StringBuffer();
        lineView.append(INITIAL_LINE);
        for (int loop = 0; loop < line.getNumberOfRung(); loop++) {
            drawRung(lineView, line.getRungOfPosition(loop));
        }
        System.out.println(lineView);
    }

    private static void drawRung(StringBuffer lineView, boolean rung) {
        if (rung) {
            lineView.append(RUNG_CONDITION_TRUE);
        }
        if (!rung) {
            lineView.append(RUNG_CONDITION_FALSE);
        }
    }
}
