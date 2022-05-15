package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;

import java.util.List;

public class Output {
    public static void printLadder(Ladder ladder) {
        // TODO :
    }

    public static void printPlayers(List<Player> players) {
        players.forEach(player -> System.out.printf("%-6s", player.getName()));
    }
}
