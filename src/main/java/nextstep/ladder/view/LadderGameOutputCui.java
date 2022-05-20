package nextstep.ladder.view;

import static java.lang.System.out;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Point;

public class LadderGameOutputCui {

    public void draw(Ladder ladder) {
        out.println("\n 사다리 결과");

        printNames(ladder.getLineNames());
        drawLines(ladder.getLadderLines());
        printResults(ladder.getResults());
    }

    private static String fixedLengthString(String string, int length) {
        return String.format("%1$"+length+ "s", string);
    }

    private void printNames(List<String> names) {
        out.print(" ");
        for (String name : names) {
            out.print(fixedLengthString(name, 6));
        } out.println();
    }

    private void drawLines(List<LadderLine> ladderLines) {
        for (LadderLine ladderLine : ladderLines) {
            drawPoints(ladderLine.getPoints());
        }
    }

    private void drawPoints(List<Point> points) {
        out.print("     ");
        for (Point point : points) {
            drawLine(point);
        }
        out.println();
    }

    private void drawLine(Point point) {
        out.print("|");
        if (point.isConnectedRight()) {
            out.print("-----");
            return;
        }
        out.print("     ");
    }

    private void printResults(List<String> results) {
        out.print(" ");
        for (String result : results) {
            out.print(fixedLengthString(result, 6));
        } out.println();
    }

    public void printResultOf(String result) {
        if ("all".equals(result)) return;

        out.println("실행 결과\n" + result);
    }

    public void printGameResults(Ladder ladder) {
        out.println("실행 결과");
        List<String> lineNames = ladder.getLineNames();
        for (String lineName : lineNames) {
            out.printf("%s : %s\n", lineName, ladder.checkResultOf(lineName));
        }
    }
}
