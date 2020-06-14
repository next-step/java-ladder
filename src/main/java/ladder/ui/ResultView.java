package ladder.ui;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Lines;
import ladder.domain.ladder.Point;
import ladder.domain.player.LadderPlayer;
import ladder.domain.player.LadderPlayers;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {

    private static final String LINE = "-----|";
    private static final String EMPTY_LINE = "     |";
    private static final String USER_INTERVAL = "%5s ";

    public static void printResult(LadderPlayers ladderPlayers, Lines lines) {
        System.out.println("실행결과");

        printLadderPlayers(ladderPlayers);
        printLadderLine(lines);
    }

    private static void printLadderPlayers(LadderPlayers ladderPlayers) {
        for (LadderPlayer ladderPlayer : ladderPlayers.getLadderPlayers()) {
            System.out.print(String.format(USER_INTERVAL, ladderPlayer.getPlayerName()));
        }
        System.out.println("");
    }

    private static void printLadderLine(Lines lines) {
        List<Line> lineList = lines.getLineList();
        lineList.forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(EMPTY_LINE);
        stringBuilder.append(buildLine(line.getPoints()));

        System.out.println(stringBuilder.toString());
    }

    private static String buildLine(List<Point> points) {
        return points.stream()
                .map(p -> p.getPointDirection().isLeft() ? LINE : EMPTY_LINE)
                .collect(joining(""));
    }
}
