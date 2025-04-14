package view;

import domain.Ladder;
import domain.LadderRow;
import domain.Player;

import java.util.List;

public class ResultView {
    public static void printResult(List<Player> players, Ladder ladder) {
        System.out.println("실행 결과");
        for (Player player : players) {
            System.out.print(String.format("%-5s ", player.getName()));
        }
        System.out.println();

        for (LadderRow ladderRow : ladder.getLadderRows()) {
            System.out.print("|");
            ladderRow.getColumns().forEach(column -> System.out.print(column ? "-----|" : "     |"));
            System.out.println();
        }
    }
}
