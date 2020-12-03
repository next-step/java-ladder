package ui;

import common.StringUtils;
import domain.*;

public class ResultView {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";
    private static final String BLANK = " ";
    private static final String NEWLINE = "\n";
    private static final int NUMBER_OF_TEMPLATE_BLANK = 4;
    private static final int NUMBER_OF_TEMPLATE_HORIZONTAL = 5;
    private static final int NUMBER_OF_NAME_PADDING = 5;

    public static void print(final LadderGame ladderGame) {
        printPlayerNames(ladderGame.getPlayerNames());
        printLadder(ladderGame.getLadder());
        printGameResults(ladderGame.getGameResults());
    }

    private static void printPlayerNames(final PlayerNames playerNames) {
        playerNames.stream().forEach( s -> padAndPrint(s));
        System.out.print(NEWLINE);
    }

    public static void printLadder(final Ladder ladder) {
        ladder.getLines().mapLineOntoPoints()
                .forEach( points -> printPoints(points));
    }

    private static void printGameResults(final GameResults gameResults ) {
        gameResults.stream().forEach( s -> padAndPrint(s));
        System.out.print(NEWLINE);
    }

    private static void padAndPrint(String s) {
        System.out.print(StringUtils.padByBlank(s, NUMBER_OF_NAME_PADDING).concat(BLANK));
    }

    private static void printPoints(Points points) {
        System.out.print(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_BLANK, BLANK));
        points.stream()
                .forEach(point -> System.out.print(convertPointToString(point)));
        System.out.print(NEWLINE);

    }

    private static String convertPointToString(final Point point) {
        return point.getDirection() == Direction.RIGHT ?
               VERTICAL.concat(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_HORIZONTAL, HORIZONTAL)) :
               VERTICAL.concat(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_HORIZONTAL, BLANK));
    }


}
