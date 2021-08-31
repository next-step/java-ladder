package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

import java.util.List;

public class ResultView {

    private static final String FALSE_LINE = "     |";
    private static final String TRUE_LINE = "-----|";
    private static final String RESULT = "실행결과";

    private ResultView() {
    }

    public static void printResult(LadderGame ladderGame) {
        System.out.println(RESULT);
        printPlayers(ladderGame.valueOfPlayers());
        printLadder(ladderGame.valueOfLadder());
    }

    private static void printLadder(Ladder ladder) {
        ladder.valueOfLines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        line.valueOfPoints()
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
        players.forEach(player -> System.out.print(String.format("%6s", player.valueOfName())));
        System.out.println();
    }

}
