package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Players;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static void showResult(Players players, Ladder ladder) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        showPlayers(players);

        showLadder(ladder);
    }

    private static void showPlayers(Players players) {
        players.getPlayers().stream()
                .forEach(player ->
                        { System.out.print(String.format("%7s", player.toString())); }
                );

        System.out.println();
    }

    private static void showLadder(Ladder ladder) {
        int height = ladder.getLines().size();
        for (int i = 0; i < height; i++) {
            Line line = ladder.getLines().get(i);
            showLine(line);
        }
    }

    private static void showLine(Line line) {
        List<Boolean> nowLine = line.getContents();

        System.out.print(String.format("%7s", "|"));
        for (Boolean isLine : nowLine) {
            showValidLine(isLine);
            System.out.print("|");
        }
        System.out.println();
    }

    public static void showValidLine(Boolean isLine) {
        if (isLine) {
            showContent("-");
            return;
        }
        showContent(" ");
    }

    private static void showContent(String contents) {
        IntStream.range(0, 6).mapToObj(j -> contents).forEach(System.out::print);

    }
}
