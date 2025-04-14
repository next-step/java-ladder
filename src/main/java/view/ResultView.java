package view;

import domain.Ladder;
import domain.Players;

public class ResultView {
    public static void printResult(Players players, Ladder ladder) {
        System.out.println("실행 결과");
        players.forEach(player -> System.out.printf("%-5s ", player.getName()));
        System.out.println();

        ladder.forEach(ladderRow -> {
            System.out.print("|");
            ladderRow.forEach(column -> System.out.print(column ? "-----|" : "     |"));
            System.out.println();
        });
    }
}
