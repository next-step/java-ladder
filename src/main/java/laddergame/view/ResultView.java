package laddergame.view;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.line.Line;
import laddergame.domain.player.Player;
import laddergame.domain.utils.Constants;

import java.util.List;

public class ResultView {

    public static void showResult() {
        System.out.println("");
        System.out.println(Constants.RESULT);
        System.out.println("");
    }

    public static void showPlayers(List<Player> players) {
        players.forEach(player -> System.out.print(player.getName() + Constants.BLANK_SPACE));
        System.out.println("");
    }

    public static void showLadder(Ladder ladder) {
        ladder.getLines().forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(Constants.LADDER_VERTICAL);
        line.getLine().forEach(ResultView::printConnection);
        System.out.println("");
    }

    private static void printConnection(boolean existConnection) {
        if (existConnection) {
            System.out.print(Constants.LADDER_CONNECTION + Constants.LADDER_VERTICAL);
            return;
        }

        System.out.print(Constants.BLANK_SPACE + Constants.LADDER_VERTICAL);
    }
}
