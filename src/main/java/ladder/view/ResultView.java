package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Players;

import java.util.List;
import java.util.stream.IntStream;

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
        IntStream.range(0, ladder.ladderHeight()).mapToObj(ladder::getLine).forEach(ResultView::showLine);
    }

    private static void showLine(Line line) {
        List<Boolean> nowLine = line.getContents();

        nowLine.forEach(isLine -> {
            System.out.print("|");
            if (isLine) {
                showContent("-");
            } else {
                showContent(" ");
            }
        });
        System.out.println("|");
    }

    private static void showContent(String contents) {
        IntStream.range(0, 9).mapToObj(j -> contents).forEach(System.out::print);
    }
}
