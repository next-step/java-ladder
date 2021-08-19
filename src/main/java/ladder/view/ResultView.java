package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Participant;
import ladder.domain.Results;

import java.util.List;

public class ResultView {
    private static final String RESULT_COMMENT = "실행 결과";
    private static final String LADDER_RESULT_COMMENT = "사다리 결과";
    private static final String BLANK = " ";
    private static final String WITH_POINTS_LINE = "-----|";
    private static final String WITHOUT_POINTS_LINE = "     |";
    private static final int MAXIMUM_OF_BLANK_SIZE = 6;

    public static void printLadderResultComment() {
        System.out.println(LADDER_RESULT_COMMENT);
    }

    public static void printResult(String result) {
        System.out.println(RESULT_COMMENT);
        System.out.println(result);
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

    public static void printParticipant(Participant participant) {
        printList(participant.getList());
        System.out.println();
    }

    public static void printInitResults(Results results) {
        printList(results.getList());
        System.out.println();
    }

    private static void printList(List<String> list) {
        list.stream()
                .forEach(result -> {
                    StringBuilder sb = getObjectWithBlank(result);
                    System.out.print(sb + result);
                });
    }

    private static StringBuilder getObjectWithBlank(String object) {
        StringBuilder sb = new StringBuilder("");
        for (int i = MAXIMUM_OF_BLANK_SIZE - object.length(); i > 0; i--) {
            sb.append(BLANK);
        }
        return sb;
    }

    public static void printResultAll(Participant participant, Results gameResults) {
        System.out.println(RESULT_COMMENT);
        List<String> participateList = participant.getList();
        List<String> finalResultsList = gameResults.getList();

        for (int i = 0; i < participant.size(); i++) {
            System.out.println(participateList.get(i) + " : " + finalResultsList.get(i));
        }
    }
}
