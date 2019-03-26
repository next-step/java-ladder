package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.players.Players;
import ladder.domain.rewards.Rewards;

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

    public static void printRewards(Rewards rewards) {
        rewards.getPeople().forEach(System.out::print);
    }
}
