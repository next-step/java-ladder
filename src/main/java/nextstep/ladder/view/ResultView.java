package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Set;

public class ResultView {
    private static final String PRINT_LINE = "-----|";
    private static final String PRINT_NO_LINE = "     |";
    private static final String FORMAT_NAME = "%6s";
    private static final String FORMAT_RESULT = "\n실행결과\n\n";
    public static final String ALL_RESULTS = "all";

    public static void printResult(final Players players, final Ladder ladder) {

        System.out.printf(FORMAT_RESULT);

        printNames(players.getPlayers());
        printLadder(ladder.getLines());
    }

    static void printNames(final List<Player> players) {
        players.stream()
                .map(player -> player.getName())
                .forEach(ResultView::printName);

        printLineFeed();
    }

    static void printName(final String name) {
        System.out.printf(String.format(FORMAT_NAME, name));
    }

    static void printLadder(final List<LadderLine> ladderLines) {
        ladderLines.stream().forEach(ResultView::printLine);
    }

    static void printLine(final LadderLine ladderLine) {
        printNoLine();

        ladderLine.getPoints()
                .stream()
                .forEach(ResultView::printColumn);

        printLineFeed();
    }

    static void printColumn(final Point point) {
        if (point.possibleGoRight() == true) {
            printLine();
            return;
        }

        printNoLine();
    }

    static void printLine() {
        System.out.print(PRINT_LINE);
    }

    static void printNoLine() {
        System.out.print(PRINT_NO_LINE);
    }

    static void printLineFeed() {
        System.out.println();
    }

    public static void printLadderResult(List<LadderResult> results) {
        results
                .forEach(result -> System.out.print(String.format("%6s", result.getResult())));
        System.out.println();
    }

    public static void printPlayersResults(String whoWantResult, GameResults gameResults) {
        System.out.println(FORMAT_RESULT);
        if (whoWantResult.equals(ALL_RESULTS)) {
            printAllPlayersResults(gameResults);
            return;
        }
        System.out.println(gameResults.findResultByPlayer(whoWantResult));
    }

    private static void printAllPlayersResults(GameResults gameResults) {
        Set<String> players = gameResults.getPlayers();
        players.forEach(player -> System.out.println(player + " : " + gameResults.findResultByPlayer(player)));
    }
}
