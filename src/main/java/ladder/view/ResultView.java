package ladder.view;

import ladder.game.LadderGame;
import ladder.game.Participants;
import ladder.game.Prizes;
import ladder.game.Results;
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

    public static boolean showResultOfParticipant(LadderGame ladderGame, String name) {
        if (EMPTY.equals(name)) {
            return false;
        }
        System.out.println(GAME_RESULT);
        Results results = ALL.equals(name)
                ? ladderGame.checkResults()
                : ladderGame.checkResults(name);
        results.values()
                .forEach((user, result)
                        -> System.out.println(String.format(GAME_RESULT_FORMAT, user, result)));
        return true;
    }

    private static void showParticipant(Participants participants) {
        List<String> names = participants.toStrings();
        for (String name : names) {
            System.out.print(String.format(PARTICIPANT_FORMAT, name));
        }
        System.out.println(EMPTY);
    }

    private static void drawLadder(Ladder ladder) {
        List<LineOfLadder> lines = ladder.getLines().getLines();
        for (LineOfLadder line : lines) {
            System.out.print(PADDING_LADDER + VERTICAL);
            drawLine(line);
            System.out.println(EMPTY);
        }
    }

    private static void drawLine(LineOfLadder line) {
        List<Connection> connections = line.getConnections();
        for (Connection connection : connections) {
            boolean isConnected = connection.isConnected();
            drawConnection(isConnected);
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
        int size = prizes.size();
        for (int i = 0; i < size; i++) {
            String result = prizes.values().get(i).toString();
            System.out.print(String.format(RESULT_FORMAT, result));
        }
        System.out.println(EMPTY);
    }
}
