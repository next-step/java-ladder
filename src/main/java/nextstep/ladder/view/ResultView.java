package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Set;

public class ResultView {

    private static final String FALSE_LINE = "     |";
    private static final String TRUE_LINE = "-----|";
    private static final String LADDER_RESULT = "\n사다리 결과";
    private static final String RESULT = "\n실행 결과";

    private ResultView() {
    }

    public static void printResult(LadderGame ladderGame) {
        System.out.println(LADDER_RESULT);
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
        System.out.println(RESULT);
        if (playersResults.equals("all")) {
            printAllPlayersResults(ladderResults);
            return;
        }
        System.out.println(ladderResults.findResultByPlayer(new Player(playersResults)));
    }

    private static void printAllPlayersResults(LadderResults ladderResults) {
        Set<Player> players = ladderResults.getPlayers();
        players.forEach(player -> System.out.println(player.getName()
                        + " : "
                        + ladderResults.findResultByPlayer(player)));
    }

}
