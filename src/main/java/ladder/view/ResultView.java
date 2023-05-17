package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.Line;

public class ResultView {

    private static final String MESSAGE_RESULT = "실행 결과";
    private static final String CONNECTION = "-----";
    private static final String DISCONNECTION = "     ";
    private static final String SINGLE_POINT = "|";

    public static void printLadder(LadderGame ladderGame) {
        System.out.println(MESSAGE_RESULT);

        ladderGame.getUnmodifiableUsers().forEach(user -> System.out.printf("%5s ", user.name()));
        System.out.println();

        ladderGame.getUnmodifiableLadderLines().forEach(ResultView::printLadderLines);
    }

    private static void printLadderLines(Line ladderLine) {
        ladderLine.getUnmodifiableListPoints().forEach(point -> System.out.print(connection(point.canMovePrevious()) + SINGLE_POINT));
        System.out.println();
    }

    private static String connection(boolean movable) {
        if (movable) {
            return CONNECTION;
        }
        return DISCONNECTION;
    }
}
