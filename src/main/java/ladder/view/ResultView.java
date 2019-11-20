package ladder.view;

import ladder.game.LadderGame;
import ladder.game.Participants;
import ladder.game.Prizes;
import ladder.game.Result;
import ladder.structure.Connection;
import ladder.structure.Ladder;
import ladder.structure.LineOfLadder;

import java.util.List;

public class ResultView {
    private static final String LADDER_RESULT = "사다리 결과";
    private static final String GAME_RESULT = "실행결과";
    private static final String EMPTY = "";
    private static final String PADDING_LADDER = "    ";
    private static final String VERTICAL = "|";
    private static final String HORIZON = "-----";
    private static final String EMPTY_HORIZON = "     ";
    private static final String PARTICIPANT_FORMAT = "%6s";
    private static final String RESULT_FORMAT = "%6s";
    private static final String GAME_RESULT_FORMAT = "%s : %s";
    private static final String ALL = "all";

    public static void showLadderResult(LadderGame ladderGame) {
        System.out.println(LADDER_RESULT);
        showParticipant(ladderGame.getParticipants());
        drawLadder(ladderGame.getLadder());
        showResults(ladderGame.getPrizes());
    }

    public static void showResultOfParticipant(LadderGame ladderGame, String name) {
        System.out.println(GAME_RESULT);
        Result results = ALL.equals(name)
                ? ladderGame.getResult()
                : ladderGame.getResult(name);
        results.getPrizeByParticipant()
                .forEach((user, result)
                        -> System.out.println(String.format(GAME_RESULT_FORMAT, user, result)));
    }

    private static void showParticipant(Participants participants) {
        List<String> names = participants.getNames();
        for (String name : names) {
            System.out.print(String.format(PARTICIPANT_FORMAT, name));
        }
        System.out.println(EMPTY);
    }

    private static void drawLadder(Ladder ladder) {
        int height = ladder.getLadderHeight();
        for (int i = 0; i < height; i++) {
            System.out.print(PADDING_LADDER + VERTICAL);
            drawLine(ladder.getLine(i), ladder.getLadderWidth());
            System.out.println(EMPTY);
        }
    }

    private static void drawLine(LineOfLadder line, int width) {
        List<Connection> connections = line.getConnections();
        for (int i = 0; i < width; i++) {
            boolean connection = connections.get(i).isConnected();
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
        int size = prizes.getSize();
        for (int i = 0; i < size; i++) {
            String result = prizes.getPrize(i);
            System.out.print(String.format(RESULT_FORMAT, result));
        }
        System.out.println(EMPTY);
    }
}
