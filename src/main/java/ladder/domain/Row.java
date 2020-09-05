package ladder.domain;

import ladder.domain.rule.DrawRule;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Row {

    private List<Boolean> lines;

    private Row(int columnCount) {
        lines = Stream.generate(() -> Boolean.FALSE)
                .limit(columnCount)
                .collect(Collectors.toList());
    }

    public static Row of(int column) {
        return new Row(column);
    }

    public int getSize() {
        return lines.size();
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

    public void drawLine(DrawRule drawRule) {
        IntStream.range(0, lines.size() - 1)
                 .forEach(columnPosition -> {
                    if (drawRule.isDrawable()) {
                        lines.set(columnPosition, isDrawable(columnPosition));
                    }
                 });
    }
}
