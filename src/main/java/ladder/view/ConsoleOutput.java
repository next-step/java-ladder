package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;

public class ConsoleOutput {

    public static void printPlayers(Players players) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        players.getPeople().forEach(System.out::print);
    }

    public static void printLadders(Ladder ladder) {
        System.out.println();
        ladder.getLines().forEach(System.out::println);
    }
}
