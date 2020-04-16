package ladder.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lines {
    private static final int DEFAULT_LINE_NUMBER = 0;
    private static final int LINE_WIDTH_DASH_NUMBER = 1;
    private static final int LINE_RANGE = 2;

    private final List<Line> lines = new ArrayList<>();

    public Lines(int personOfCount) {
        lines.add(Line.createByNumber(DEFAULT_LINE_NUMBER));
        for (int position = 1; position < personOfCount; position++) {
            makeLines(position);
        }
    }

    public int move(int userPosition) {
        if (canMoveRight(userPosition)) {
            return userPosition + 1;
        }
        if (canMoveLeft(userPosition)) {
            return userPosition - 1;
        }
        return userPosition;
    }

    private boolean canMoveLeft(int userPosition) {
        if (userPosition == 0) {
            return false;
        }
        return lines.get(userPosition).lineValue() == LINE_WIDTH_DASH_NUMBER;
    }

    private boolean canMoveRight(int userPosition) {
        if (userPosition == lines.size() -1 ) {
            return false;
        }
        return lines.get(userPosition + 1).lineValue() == LINE_WIDTH_DASH_NUMBER;
    }

    public List<String> showLines() {
        return lines.stream()
                .map(Line::draw)
                .collect(Collectors.toList());
    }

    private void makeLines(int position) {
        if (isLatestLine(position, LINE_WIDTH_DASH_NUMBER)) {
            lines.add(Line.createByNumber(DEFAULT_LINE_NUMBER));
            return;
        }
        lines.add(Line.createByNumber(random()));
    }

    private boolean isLatestLine(int position, int lineValue) {
        return lines.get(position - 1).lineValue() == lineValue;
    }

    private int random() {
        if ((Math.random() * LINE_RANGE) < LINE_WIDTH_DASH_NUMBER) {
            return DEFAULT_LINE_NUMBER;
        }
        return LINE_WIDTH_DASH_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines line1 = (Lines) o;
        return Objects.equals(lines, line1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
