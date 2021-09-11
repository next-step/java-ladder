package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;

import java.util.List;

public class ResultView {
    private static final String PRINT_LINE = "-----|";
    private static final String PRINT_NO_LINE = "     |";
    private static final String FORMAT_NAME = "%6s";
    private static final String FORMAT_RESULT = "\n실행결과\n\n";

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

    static void printLadder(final List<Line> ladderFloors) {
        ladderFloors.stream().forEach(ResultView::printLine);
    }

    static void printLine(final Line line) {
        printNoLine();

        line.getPoints()
                .stream()
                .forEach(ResultView::printColumn);

        printLineFeed();
    }

    static void printColumn(final boolean line) {
        if (line == true) {
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
}
