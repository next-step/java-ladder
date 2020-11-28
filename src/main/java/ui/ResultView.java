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
    }

    private static void printPlayerNames(final PlayerNames playerNames) {
        playerNames.stream().forEach(s -> {
            System.out.print(StringUtils.padByBlank(s, NUMBER_OF_NAME_PADDING).concat(BLANK));
        });
        System.out.print(NEWLINE);
    }

    public static void printLadder(final Ladder ladder) {
        ladder.getLines().stream().map(Line::getPoints).forEach(points -> {
            System.out.print(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_BLANK, BLANK));
            points.stream().forEach( point -> System.out.print(convertPointToString(point.isPresent())) );
            System.out.println(VERTICAL);
        });
    }

    private static String convertPointToString(final boolean isPresent) {
        return isPresent ?
               VERTICAL.concat(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_HORIZONTAL, HORIZONTAL)) :
               VERTICAL.concat(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_HORIZONTAL, BLANK));
    }
}
