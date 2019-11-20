package ladder.view;

import ladder.game.LadderGame;
import ladder.game.Participants;
import ladder.game.Prizes;
import ladder.game.Result;
import ladder.structure.Ladder;
import ladder.structure.LineOfLadder;

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
        Result results;

        results = "all".equals(name)
                ? ladderGame.getResult()
                : ladderGame.getResult(name);

        results.getPrizeByParticipant().forEach((user, result) -> {
            System.out.println(String.format(GAME_RESULT_FORMAT, user, result));
        });
    }

    private static void showParticipant(Participants participants) {
        List<String> names = participants.getNames();
        for (String name : names) {
            arrangeCenterOfSpace(PARTICIPANT_FORMAT, name);
        }
        System.out.println(EMPTY);
    }

    private static void drawLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getLadderHeight(); i++) {
            System.out.print(DOUBLE_SPACE + VERTICAL);
            drawLine(ladder.getLine(i), ladder.getLadderWidth());
            System.out.println(EMPTY);
        }
    }

    private static void drawLine(LineOfLadder line, int width) {
        for (int i = 0; i < width; i++) {
            boolean connection = line.isConnected(i);
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

    private static void showResults(Prizes prizes) {
        for (int i = 0; i < prizes.getSize(); i++) {
            String result = prizes.getPrize(i);
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
