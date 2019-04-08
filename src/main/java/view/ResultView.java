package view;

import domain.Ladder;
import domain.Players;

public class ResultView {
    public static void printLadders(Players players, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println(players.toString());
        ladder.printLadder();
    }
}
