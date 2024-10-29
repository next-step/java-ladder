package nextstep.ladder.domain;

import java.util.List;

public class LadderPrinter {

    private final Ladder ladder;

    public LadderPrinter(Ladder ladder) {
        this.ladder = ladder;
    }

    public String printLadder() {
        StringBuilder result = new StringBuilder();
        for (Line line : ladder.getLines()) {
            result.append(convertLineToString(line));
        }
        return result.toString();
    }

    private String convertLineToString(Line line) {
        List<Point> points = line.getPoints();
        StringBuilder builder = new StringBuilder();
        builder.append("     ");
        for (int cnt = 0; cnt < points.size() - 1; cnt++) {
            Point point = points.get(cnt);
            if (point.isRightConnected()) {
                builder.append("|-----");
                continue;
            }
            builder.append("|     ");
        }
        builder.append("|\n");
        return builder.toString();
    }
}
