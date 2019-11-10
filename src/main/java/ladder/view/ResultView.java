package ladder.view;

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
    private static final String EMPTY_HORIZON = "     ";
    private static final int NAME_SPACE_SIZE = 6;

    public static void show(LadderGame ladderGame) {
        System.out.println(RESULT);
        showParticipant(ladderGame.getParticipants());
        drawLadder(ladderGame);
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

    private static void drawLadder(LadderGame ladderGame) {
        int ladderHeight = ladderGame.getLadderHeight();
        int lineWidth = ladderGame.getLadderWidth();

        for (int line = 0; line < ladderHeight; line++) {
            System.out.print(DOUBLE_SPACE + VERTICAL);
            drawLine(ladderGame, line, lineWidth);
            System.out.println(EMPTY);
        }
        System.out.println(EMPTY);
    }

    private static void drawLine(LadderGame ladderGame, int line, int lineWidth) {
        for (int width = 0; width < lineWidth; width++) {
            drawConnection(ladderGame.isConnected(line, width));
        }
    }

    private static void drawConnection(boolean isConnected) {
        if (isConnected) {
            System.out.print(HORIZON + VERTICAL);
        } else {
            System.out.print(EMPTY_HORIZON + VERTICAL);
        }
    }
}
