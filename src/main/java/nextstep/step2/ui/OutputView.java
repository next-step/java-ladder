package nextstep.step2.ui;

import java.util.Map;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.Line;
import nextstep.step2.domain.Player;
import nextstep.step2.domain.Players;
import nextstep.step2.domain.Point;
import nextstep.step2.domain.Result;

public class OutputView {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String HORIZONTAL_BLANK = "     ";

    public static void printLadderModel(Players players, Ladder ladder) {
        System.out.println("\n사다리 결과\n");
        printPlayersName(players);
        printLadder(ladder);
    }

    private static void printPlayersName(final Players players) {
        players.getPlayers()
               .stream()
               .map(player -> String.format("%-6s", player))
               .forEach(System.out::print);
        System.out.println();
    }

    private static void printLadder(final Ladder ladder) {
        for (Line line : ladder.getLines()) {
            line.getPoints()
                .stream()
                .map(OutputView::getLadder)
                .forEach(System.out::print);
            System.out.println();
        }
    }

    private static String getLadder(Point point) {
        if (point.getDirections().isRightLine()) {
            return VERTICAL_LINE + HORIZONTAL_LINE;
        }

        return VERTICAL_LINE + HORIZONTAL_BLANK;
    }

    public static void printResult(Result result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public static void printTotalResults(Map<Player, Result> playerResults) {
        System.out.println("실행 결과");
        for (Map.Entry entry : playerResults.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
