package ui;

import common.StringUtils;
import domain.*;

public class ResultView {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";
    private static final String BLANK = " ";
    private static final String NEWLINE = "\n";
    private static final String LADDER_RESULTS_ARE = "사다리 결과";
    private static final String EXECUTION_RESULTS_ARE = "실행 결과";
    private static final String ALL_RESULTS_PRINT_FORMAT = "%s : %s\n";
    private static final int NUMBER_OF_TEMPLATE_BLANK = 4;
    private static final int NUMBER_OF_TEMPLATE_HORIZONTAL = 5;
    private static final int NUMBER_OF_NAME_PADDING = 5;

    private ResultView(){}

    public static void print(final LadderGame ladderGame) {
        System.out.println(LADDER_RESULTS_ARE);
        printPlayerNames(ladderGame.getPlayerNames());
        printLadder(ladderGame.getLadder());
        printGameResults(ladderGame.getGameResults());
    }

    private static void printPlayerNames(final PlayerNames playerNames) {
        playerNames.unbox().forEach(s -> padAndPrint(s));
        System.out.print(NEWLINE);
    }

    private static void printLadder(final Ladder ladder) {
        ladder.getLines().unbox()
                .stream()
                .map( line -> line.getPoints() )
                .forEach( points -> printPoints(points));
    }

    private static void printGameResults(final GameResults gameResults ) {
        gameResults.unbox().forEach( s -> padAndPrint(s));
        System.out.print(NEWLINE);
    }

    private static void padAndPrint(final String s) {
        System.out.print(StringUtils.padByBlank(s, NUMBER_OF_NAME_PADDING).concat(BLANK));
    }

    private static void printPoints(final Points points) {
        System.out.print(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_BLANK, BLANK));
        points.unbox().forEach(point -> System.out.print(convertPointToString(point)));
        System.out.print(NEWLINE);

    }

    private static String convertPointToString(final Point point) {
        return point.isHeadingRight() ?
               VERTICAL.concat(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_HORIZONTAL, HORIZONTAL)) :
               VERTICAL.concat(StringUtils.copyAndJoin(NUMBER_OF_TEMPLATE_HORIZONTAL, BLANK));
    }

    public static void printResultOf(final LadderGame ladderGame, final String name) {
        System.out.println(EXECUTION_RESULTS_ARE);
        System.out.println(ladderGame.fetchResultOf(name));
    }

    public static void printAllResults(final LadderGame ladderGame) {
        ResultMap resultMap = ladderGame.fetchAllResults();
        System.out.println(EXECUTION_RESULTS_ARE);
        for(String key : resultMap.keySet()) {
            System.out.printf(ALL_RESULTS_PRINT_FORMAT, key, resultMap.get(key)) ;
        }
    }
}
