package ladder.view;

import ladder.game.LadderGame;
import ladder.game.LineOfLadder;

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
        drawLadder(ladderGame.getLadderTable());
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

    private static void drawLadder(List<LineOfLadder> ladderTable) {
        for (LineOfLadder line : ladderTable) {
            System.out.print(DOUBLE_SPACE + VERTICAL);
            for (Boolean value : line.getLineConnection()) {
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
