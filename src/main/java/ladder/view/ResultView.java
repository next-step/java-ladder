package ladder.view;

import ladder.domain.LadderResult;
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

    private final LadderResult ladderResult;

    public ResultView(LadderResult ladderResult) {
        this.ladderResult = ladderResult;
    }

    public void showLadderDrawResult() {
        printHeader();
        printPlayers();
        printNewLine();
        printLadder();
    }

    private void printHeader() {
        printNewLine();
        System.out.println("사다리 결과");
        printNewLine();
    }

    private void printLadder() {
        ladderResult.getLines()
                .forEach(line -> printLine(line.getPoints()));
    }

    private void printLine(List<Point> points) {
        StringBuffer sb = new StringBuffer();
        sb.append(indent());
        points.forEach(point -> {
            sb.append(ROOT);
            sb.append(makeRightLine(point));
        });
        System.out.println(sb);
    }

    private String makeRightLine(Point point) {
        if (point.hasRightDirection()) {
            return times(DASH);
        }
        return times(SPACE);
    }

    private void printNewLine() {
        System.out.println();
    }

    private void printPlayers() {
        Optional.of(ladderResult.getPlayers())
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
