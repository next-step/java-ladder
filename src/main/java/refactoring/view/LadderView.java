package refactoring.view;

import static refactoring.domain.LineStatus.CONNECTION;

import java.util.List;
import refactoring.domain.Ladder;
import refactoring.domain.Line;
import refactoring.domain.LineStatus;
import refactoring.domain.Players;
import refactoring.domain.Point;
import refactoring.domain.Results;

public class LadderView {

    private static final String WIDTH_LINE = "------";
    private static final String BLANK = "      ";
    private static final String HEIGHT_LINE = "|";
    private static final String NEW_LINE = "\n";

    private final Players players;
    private final Ladder ladder;

    public LadderView(final Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public void printLadder(Results results) {
        System.out.println("실행결과");
        System.out.println();

        StringBuilder sb = new StringBuilder();
        printNames(sb);
        printLadder(sb);

        results.get().forEach(result -> sb.append(result).append(BLANK));

        System.out.println(sb);
    }


    private void printNames(final StringBuilder sb) {
        players.getNames().forEach(name -> sb.append(name.get()).append(BLANK));
        sb.append(NEW_LINE);
    }

    private void printLadder(final StringBuilder sb) {
        for (final Line line : ladder.get()) {
            List<Point> points = line.getPoint();
            for (final Point point : points) {
                LineStatus lineStatus = point.getConnection();
                if (lineStatus == CONNECTION) {
                    sb.append(HEIGHT_LINE).append(WIDTH_LINE);
                } else {
                    sb.append(HEIGHT_LINE).append(BLANK);
                }
            }
            sb.append(NEW_LINE);
        }
    }

}

