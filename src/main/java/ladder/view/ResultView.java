package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderPlayers;

public class ResultView {

    public static void drawLadderPlayers(LadderPlayers players) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        players.getPlayers()
                .forEach(System.out::print);

        System.out.println();

    }

    public static void drawLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(System.out::println);
    }
}
