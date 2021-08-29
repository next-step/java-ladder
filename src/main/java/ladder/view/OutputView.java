package ladder.view;

import ladder.model.LadderGame;
import ladder.model.Line;
import ladder.model.Player;

import java.util.List;

public class OutputView {

    private static final String LADDER_LINE = "|";
    private static final String STEP = "-----";
    private static final String FIVE_BLANK = "     ";
    private static final String RESULT_MSG = "실행결과";
    private static final String PLAYER_NAME_FORMAT = "%5s ";

    public static void printResult(LadderGame ladderGame) {
        printMessageBeforePrintResult();
        printPlayers(ladderGame.getPlayers());
        printLadder(ladderGame.getLadder());
    }

    private static void printMessageBeforePrintResult() {
        System.out.println(RESULT_MSG);
        emptyLine();
    }

    private static void printPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.print(String.format(PLAYER_NAME_FORMAT, player.getName()));
        }
        emptyLine();
    }

    private static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            printLine(line);
            emptyLine();
        }
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
