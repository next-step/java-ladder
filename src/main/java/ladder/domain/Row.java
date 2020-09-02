package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Row {

    private List<Boolean> lines;

    private Row(int columnNumber) {
        lines = new ArrayList<>();
        IntStream.range(0, columnNumber-1)
                .forEach(i -> lines.add(Boolean.FALSE));
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
