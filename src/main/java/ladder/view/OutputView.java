package ladder.view;

import ladder.Ladder;
import ladder.LadderPlayers;

public class OutputView {

    public static void printPlayer(LadderPlayers players) {
        players.getPlayers().forEach(System.out::print);
    }

    public static void printLadders(Ladder ladder) {
        System.out.println();
        ladder.getLines().forEach(System.out::println);
    }
}
