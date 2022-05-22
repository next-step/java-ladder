package ladder.view;


import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Players;

import java.util.List;

public class ResultView {
    public static void showResult(Players players, Ladder ladder) {
        System.out.println("실행결과");

        showPlayers(players);

        showLadder(ladder);
    }

    private static void showPlayers(Players players) {
        players.getPlayers().stream()
                .forEach(player ->
                        { System.out.print(player.getName() + "     "); }
                );
        System.out.println();
    }

    private static void showLadder(Ladder ladder) {
        for (int i = 0; i < ladder.ladderHeight(); ++i) {
            showLine(ladder.getLine(i));
        }
    }

    private static void showLine(Line line) {
        List<Boolean> nowLine = line.getLine();

        for (Boolean isLine : nowLine) {
            System.out.print("|");
            if (isLine) {
                showContent("-");
            } else {
                showContent(" ");
            }
        }
        System.out.println("|");
    }

    private static void showContent(String contents) {
        for (int j = 0; j < 9; ++j) {
            System.out.print(contents);
        }
    }
}
