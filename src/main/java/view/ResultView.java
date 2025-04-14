package view;

import domain.Ladder;
import domain.Player;

import java.util.List;

public class ResultView {
    public static void printResult(List<Player> players, Ladder ladder) {
        System.out.println("실행 결과");
        for (Player player : players) {
            System.out.print(player.getName());
        }
        System.out.println();
        System.out.println(ladder.toString());
    }
}
