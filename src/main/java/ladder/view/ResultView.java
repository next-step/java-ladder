package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Participant;
import ladder.domain.Results;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String RESULT_COMMENT = "실행 결과";
    private static final String LADDER_RESULT_COMMENT = "사다리 결과";
    private static final String BLANK = " ";
    private static final String WITH_POINTS_LINE = "-----|";
    private static final String WITHOUT_POINTS_LINE = "     |";
    private static final int MAXIMUM_OF_BLANK_SIZE = 6;
    private static final String SHOW_RESULT_ALL = "all";

    public static void printLadderResultComment() {
        System.out.println(LADDER_RESULT_COMMENT);
    }

    public static void printResult(String person, GameResult gameResult) {
        System.out.println(RESULT_COMMENT);

        Map<String, String> map = gameResult.getGameResult();

        if (SHOW_RESULT_ALL.equals(person)) {
            map.forEach((participant, result) -> System.out.println(participant + " : " + result));
            return;
        }
        System.out.println(map.get(person));
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
}
