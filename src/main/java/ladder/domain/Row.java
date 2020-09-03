package ladder.domain;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {

    private List<Boolean> lines;

    private Row(int columnNumber) {
        lines = Stream.generate(() -> Boolean.FALSE)
                .limit(columnNumber-1)
                .collect(Collectors.toList());
    }

    public static Row valueOf(int column) {
        return new Row(column);
    }

    public void drawLine(int position) {
        lines.set(position, isDrawable(position));
    }

    public int getSize() {
        return lines.size() + 1;
    }

    public boolean hasLine(int column) {
        return lines.get(column);
    }

    private boolean isDrawable(int position) {
        if (position == 0) {
            return true;
        }
        return !lines.get(position - 1);
    }
}
