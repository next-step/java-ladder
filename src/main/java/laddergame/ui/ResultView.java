package laddergame.ui;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.List;

import static laddergame.util.StringUtils.fitLine;
import static laddergame.util.StringUtils.fitName;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과\n";

    public static void printNames(Players players) {
        List<Player> playerList = players.getPlayers();
        playerList.forEach(player ->
                System.out.print(fitName(player.toString())));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> System.out.println(fitLine(line)));
    }
}
