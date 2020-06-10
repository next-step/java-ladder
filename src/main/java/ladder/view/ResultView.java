package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

public class ResultView {

    public static final String COLUMN = "|";
    public static final String BLANK_LINE = "     ";
    public static final String LINE = "-----";

    public void printLadder(Players players, Ladder ladder) {
        System.out.println("\n실행결과\n");
        players.stream().map(Player::getName).forEach(name -> System.out.printf("%6s", name));
        System.out.println();
        ladder.stream().forEach(line -> {
            System.out.print(BLANK_LINE);
            line.stream().forEach(point -> System.out.print(COLUMN + (point.hasLine() ? LINE : BLANK_LINE)));
            System.out.println();
        });
    }
}
