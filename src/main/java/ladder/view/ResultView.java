package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;

public class ResultView {


    private static final String RESULT = "\n실행결과\n";

    public static void printResult() {
        System.out.println(RESULT);
    }

    public static void printPlayers(Players players) {
        players.getPlayers()
                .forEach(Player::print);
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(Line::print);
        System.out.println();
    }

}
