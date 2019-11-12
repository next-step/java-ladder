package ladder.view;

import ladder.game.LadderGame;

import java.util.Collections;
import java.util.List;

public class ResultView {
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String GAME_RESULT = "실행결과";
    private static final String EMPTY = "";
    private static final String SINGLE_SPACE = " ";
    private static final String DOUBLE_SPACE = "  ";
    private static final String VERTICAL = "|";
    private static final String HORIZON = "-----";
    private static final String EMPTY_HORIZON = "     ";
    private static final String PARTICIPANT_FORMAT = "%s%s%s";
    private static final String RESULT_FORMAT = "%s%s%s";
    private static final int NAME_SPACE_SIZE = 6;

    public static void showLadderResult(LadderGame ladderGame) {
        System.out.println(LADDER_RESULT);
        showParticipant(ladderGame.getParticipants());
        drawLadder(ladderGame);
        showResults(ladderGame.getResults());
    }

    private static void showParticipant(List<String> participants) {
        for (String participant : participants) {
            int left = (NAME_SPACE_SIZE - participant.length()) / 2;
            int right = NAME_SPACE_SIZE - participant.length() - left;
            System.out.print(
                    String.format(
                            PARTICIPANT_FORMAT, String.join(EMPTY, Collections.nCopies(left, SINGLE_SPACE)),
                            participant,
                            String.join(EMPTY, Collections.nCopies(right, SINGLE_SPACE)))
            );
        }
        System.out.println(EMPTY);
    }

    private static void drawLadder(LadderGame ladderGame) {
        int ladderHeight = ladderGame.getLadderHeight();
        int lineWidth = ladderGame.getLadderWidth();

        for (int line = 0; line < ladderHeight; line++) {
            System.out.print(DOUBLE_SPACE + VERTICAL);
            drawLine(ladderGame, line, lineWidth);
            System.out.println(EMPTY);
        }
    }

    private static void showResults(List<String> results) {
        for ( String result : results ) {
            int left = (NAME_SPACE_SIZE - result.length()) / 2;
            int right = NAME_SPACE_SIZE - result.length() - left;
            System.out.print(
                    String.format(RESULT_FORMAT,
                        String.join(EMPTY, Collections.nCopies(left, SINGLE_SPACE)),
                        result,
                        String.join(EMPTY, Collections.nCopies(right, SINGLE_SPACE)))
            );
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
