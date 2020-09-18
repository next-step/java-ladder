package laddergame.view;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.line.Line;
import laddergame.domain.player.Player;
import laddergame.domain.prize.Prize;
import laddergame.domain.utils.Constants;

import java.util.List;

public class ResultView {

    public static void showLadderResult() {
        System.out.println("");
        System.out.println(Constants.LADDER_RESULT);
        System.out.println("");
    }

    public static void showGamePrize(Player player) {
        System.out.println("");
        System.out.println(Constants.GAME_PRIZE);
        System.out.println(player.getPrize());
    }

    public static void showGameTotalPrize(List<Player> player) {
        System.out.println("");
        System.out.println(Constants.GAME_PRIZE);
        player.forEach(p -> System.out.println(p.getName() + Constants.FINAL_RESULT_SEPERATOR + p.getPrize()));
    }

    public static void showPlayers(List<Player> players) {
        players.forEach(player -> System.out.print(player.getName() + Constants.PLAYER_BLANK_SPACE));
        System.out.println("");
    }

    public static void showPrizes(List<Prize> prizes) {
        prizes.forEach(player -> System.out.print(player.getContent() + Constants.PRIZE_BLANK_SPACE));
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

        System.out.print(Constants.LADDER_BLANK_SPACE + Constants.LADDER_VERTICAL);
    }
}
