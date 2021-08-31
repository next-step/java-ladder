package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {

    private static final String FALSE_LINE = "     |";
    private static final String TRUE_LINE = "-----|";
    private static final String RESULT = "실행결과";

    private ResultView() {
    }

    public static void printResult(LadderGame ladderGame) {
        System.out.println(RESULT);
        printPlayers(ladderGame.getPlayers());
        printLadder(ladderGame.getLadder());
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        line.getPoints()
                .forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(boolean point) {
        if (point) {
            System.out.print(TRUE_LINE);
            return;
        }
        System.out.print(FALSE_LINE);
    }

    private static void printPlayers(List<Player> players) {
        players.forEach(player -> System.out.print(String.format("%6s", player.getName())));
        System.out.println();
    }

    public static void printLadderResult(List<String> results) {
        results
                .forEach(p -> System.out.print(String.format("%6s", p)));
        System.out.println();
    }

    public static void printPlayersResults(String playersResults, LadderResults ladderResults) {
        if (playersResults.equals("all")) {
            printAllPlayersResults(ladderResults);
            return;
        }
        printPlayerResult();
    }

    private static void printAllPlayersResults(LadderResults ladderResults) {
    }

    private static void printPlayerResult() {
    }
}
