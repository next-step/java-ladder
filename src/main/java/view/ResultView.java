package view;

import domain.Ladder;
import domain.Player;
import domain.PlayerGroup;

import java.util.List;

public class ResultView {

    public static void resultStart() {
        System.out.println("실행결과");
    }

    public static void printNames(List<Player> players) {
        players.forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(System.out::println);
    }

    public static void printOneResult(int startPosition, PlayerGroup resultGroup, Ladder ladder) {
        System.out.println(resultGroup.getName(ladder.getFinalPosition(startPosition)));
    }

    public static void printAllResult(PlayerGroup playerGroup, PlayerGroup resultGroup, Ladder ladder) {
        for (int i = 0; i < playerGroup.getSize(); i++) {
            int finalPosition = ladder.getFinalPosition(i);
            String str = playerGroup.getName(i) + ": " + resultGroup.getName(finalPosition);
            System.out.println(str);
        }
    }
}
