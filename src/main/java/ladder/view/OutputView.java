package ladder.view;

import ladder.model.*;

import java.util.List;

public class OutputView {

    private static final String LADDER_LINE = "|";
    private static final String STEP = "-----";
    private static final String FIVE_BLANK = "     ";
    private static final String ONE_BLANK = " ";
    private static final String RESULT_LADDER_MSG = "사다리 결과";
    private static final String RESULT_MATCH_MSG = "실행 결과";
    private static final String PLAYER_NAME_FORMAT = "%5s ";
    private static final String RESULT_LIST_FORMAT = "%5s ";
    private static final String DELIMITER = ":";

    public static void printMessageBeforePrintResult() {
        emptyLine();
        System.out.println(RESULT_LADDER_MSG);
        emptyLine();
    }

    public static void printPlayers(List<Player> players) {
        emptyLine();
        for (Player player : players) {
            System.out.print(String.format(PLAYER_NAME_FORMAT, player.getName()));
        }
        emptyLine();
    }

    public static void printLadder(Ladder ladder) {
        emptyLine();
        for (Line line : ladder.getLines()) {
            printLine(line);
            emptyLine();
        }
    }

    public static void printResultList(List<PlayingResult> playingResults) {
        emptyLine();
        for (PlayingResult result : playingResults) {
            System.out.print(String.format(RESULT_LIST_FORMAT, result.getResult()));
        }
        emptyLine();
    }

    public static void printResult(PlayingResult result) {
        emptyLine();
        System.out.println(RESULT_MATCH_MSG);
        System.out.println(result.getResult());
        emptyLine();
    }

    public static void printResult(List<Player> players, List<PlayingResult> playingResults) {
        System.out.println(RESULT_MATCH_MSG);
        int size = players.size();
        for (int idx = 0; idx < size; idx++) {
            Player player = players.get(idx);
            PlayingResult result = playingResults.get(idx);
            System.out.println(combinePlayerAndResult(player, result));
        }
        emptyLine();
    }

    private static String combinePlayerAndResult(Player player, PlayingResult result) {
        return player.getName() + ONE_BLANK + DELIMITER + ONE_BLANK + result.getResult();
    }

    private static void printLine(Line line) {
        for (Boolean step : line.getSteps()) {
            System.out.print(stepToString(step));
            System.out.print(LADDER_LINE);
        }
    }

    private static String stepToString(Boolean step) {
        if (step) {
            return STEP;
        }
        return FIVE_BLANK;

    }

    private static void emptyLine() {
        System.out.println();
    }

}
