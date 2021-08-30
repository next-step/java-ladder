package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

import java.util.List;

public class ResultView {

    private static final String FALSE = "     |";
    private static final String TRUE = "-----|";

    private ResultView() {
    }

    public static void printResult(LadderGame ladderGame) {
        System.out.println("실행결과");
        printPlayers(ladderGame.valueOfPlayers());
        printLadder(ladderGame.valueOfLadder());
    }

    private static void printLadder(Ladder ladder) {
        ladder.valueOfLines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        line.valueOfPoints()
                .forEach(point -> {
                    if (point) System.out.print(TRUE);
                    else System.out.print(FALSE);
                });
        System.out.println();
    }

    private static void printPlayers(List<Player> players) {
        players.forEach(player -> System.out.print(String.format("%6s", player.valueOfName())));
        System.out.println();
    }

}
