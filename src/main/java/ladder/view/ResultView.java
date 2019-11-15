package ladder.view;

import ladder.game.LadderGame;
import ladder.structure.LineOfLadder;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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
    private static final String GAME_RESULT_FORMAT = "%s : %s";
    private static final int NAME_SPACE_SIZE = 6;

    public static void showLadderResult(LadderGame ladderGame) {
        System.out.println(LADDER_RESULT);
        showParticipant(ladderGame.getParticipants());
        drawLadder(ladderGame.getLadder());
        showResults(ladderGame.getPrizes());
    }

    public static void showResultOfParticipant(LadderGame ladderGame, String name) {
        System.out.println(GAME_RESULT);
        Map<String, String> results;
        if ("all".equals(name)) {
            results = ladderGame.getResult(ladderGame.getParticipants().stream().toArray(String[]::new));
        } else {
            results = ladderGame.getResult(name);
        }

        results.forEach((user, result) -> {
            System.out.println(String.format(GAME_RESULT_FORMAT, user, result));
        });
    }

    private static void showParticipant(List<String> participants) {
        for (String participant : participants) {
            arrangeCenterOfSpace(PARTICIPANT_FORMAT, participant);
        }
        System.out.println(EMPTY);
    }

    private static void drawLadder(List<LineOfLadder> ladder) {
        for (LineOfLadder line : ladder) {
            System.out.print(DOUBLE_SPACE + VERTICAL);
            drawLine(line.getConnections());
            System.out.println(EMPTY);
        }
    }

    private static void drawLine(List<Boolean> line) {
        for (Boolean connection : line) {
            drawConnection(connection);
        }
    }

    private static void drawConnection(boolean isConnected) {
        if (isConnected) {
            System.out.print(HORIZON + VERTICAL);
        } else {
            System.out.print(EMPTY_HORIZON + VERTICAL);
        }
    }

    private static void showResults(List<String> results) {
        for (String result : results) {
            arrangeCenterOfSpace(RESULT_FORMAT, result);
        }
        System.out.println(EMPTY);
    }

    private static void arrangeCenterOfSpace(String format, String string) {
        int left = (NAME_SPACE_SIZE - string.length()) / 2;
        int right = NAME_SPACE_SIZE - string.length() - left;
        System.out.print(
                String.format(format,
                        String.join(EMPTY, Collections.nCopies(left, SINGLE_SPACE)),
                        string,
                        String.join(EMPTY, Collections.nCopies(right, SINGLE_SPACE)))
        );
    }
}
