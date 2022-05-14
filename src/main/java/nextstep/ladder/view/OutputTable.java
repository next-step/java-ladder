package nextstep.ladder.view;

import nextstep.ladder.model.Bar;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;

import java.util.List;

public final class OutputTable {

    private static final String EXECUTION_RESULT = "실행결과";
    private static final String LADDER_ACTIVE_BAR = "|-----";
    private static final String LADDER_NOT_ACTIVE_BAR = "|     ";
    private static final String BLANK = " ";
    private static final int LADDER_WEIGHT_SIZE = 5;

    private OutputTable() {
    }

    public static void executionResult() {
        System.out.println();
        System.out.println(EXECUTION_RESULT);
        System.out.println();
    }

    public static void printParticipantNames(List<String> participantNames) {
        StringBuilder result = new StringBuilder();
        for (String participantName : participantNames) {
            int repeat = LADDER_WEIGHT_SIZE - participantName.length();
            participantName = BLANK.repeat(repeat).concat(participantName);
            result.append(participantName);
        }
        System.out.println(result);
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.lines()) {
            printBars(line);
            System.out.println();
        }
    }

    private static void printBars(Line line) {
        for (Bar bar : line.bars()) {
            activatePrint(bar.isActivate());
        }
    }

    private static void activatePrint(boolean activate) {
        if (activate) {
            System.out.print(LADDER_ACTIVE_BAR);
            return;
        }
        System.out.print(LADDER_NOT_ACTIVE_BAR);
    }
}
