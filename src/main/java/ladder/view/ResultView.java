package ladder.view;

import ladder.domain.LineResults;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Point;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ResultView {
    private static final String SPACE = " ";
    private static final String DASH = "-";
    private static final String ROOT = "|";

    private final Players players;
    private LineResults lineResults;

    public ResultView(Players players, LineResults lineResults) {
        this.players = players;
        this.lineResults = lineResults;
    }

    public void showLadderDrawResult() {
        printPlayers();
        printNewLine();
        printLadder();
    }

    private void printLadder() {
        lineResults.getLineResults()
                .forEach(line -> printLine(line.getPoints()));
    }

    private void printLine(List<Point> points) {
        StringBuffer sb = new StringBuffer();
        sb.append(indent());
        points.forEach(point -> {
            sb.append(ROOT);
            sb.append(point.hasRightDirection() ? times(DASH) : times(SPACE));
        });
        System.out.println(sb);
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printPlayers() {
        Optional.of(players)
                .map(Players::allPlayers)
                .orElseThrow(IllegalArgumentException::new)
                .forEach(player -> System.out.print(padLeft(player.getName(), Player.MAX_SIZE + 1)));
    }

    private String padLeft(String inputString, int padCount) {
        return String.format("%1$" + padCount + "s", inputString);
    }

    private static String indent() {
        return Stream.generate(() -> SPACE)
                .limit(Player.MAX_SIZE)
                .reduce("", (a, b) -> a + b);
    }

    private String times(String target) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < Player.MAX_SIZE; i++) {
            sb.append(target);
        }
        return sb.toString();
    }
}
