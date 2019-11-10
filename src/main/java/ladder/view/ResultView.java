package ladder.view;

import ladder.game.Ladder;
import ladder.game.LadderGame;

import java.util.Collections;
import java.util.List;

public class ResultView {
    private static final String RESULT = "실행결과";
    private static final String EMPTY = "";
    private static final String SINGLE_SPACE = " ";
    private static final String DOUBLE_SPACE = "  ";
    private static final String VERTICAL = "|";
    private static final String HORIZON = "-----";
    private static final String EMPTY_VERTICAL = "     ";
    private static final int NAME_SPACE_SIZE = 6;

    public static void show(LadderGame ladderGame) {
        System.out.println(RESULT);
        showParticipant(ladderGame.getParticipants());
        drawLadder(ladderGame.getLadder());
    }

    private static void showParticipant(List<String> participants) {
        for (String participant : participants) {
            int left = (NAME_SPACE_SIZE - participant.length()) / 2;
            int right = NAME_SPACE_SIZE - participant.length() - left;
            System.out.print(String.join(EMPTY, Collections.nCopies(left, SINGLE_SPACE)));
            System.out.print(participant);
            System.out.print(String.join(EMPTY, Collections.nCopies(right, SINGLE_SPACE)));
        }
        System.out.println();
    }

    private static void drawLadder(Ladder ladder) {
        boolean[][] ladderTable = ladder.getLadder();
        for (boolean[] line : ladderTable) {
            System.out.print(DOUBLE_SPACE + VERTICAL);
            for (boolean value : line) {
                if (value) {
                    System.out.print(HORIZON + VERTICAL);
                } else {
                    System.out.print(EMPTY_VERTICAL + VERTICAL);
                }
            }
            System.out.println(EMPTY);
        }
        System.out.println(EMPTY);
    }
}
