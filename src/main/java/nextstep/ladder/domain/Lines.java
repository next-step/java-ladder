package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import nextstep.ladder.domain.interfaces.LineCreationStrategy;

public class Lines {
    private static final int EXIST_DIVISION = 2;

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    private static Lines of (List<Line> lines) {
        return new Lines(lines);
    }

    public static Lines of (int maxNum, LineCreationStrategy lineCreationStrategy) {
        return of(drawLine(maxNum, lineCreationStrategy));
    }

    private static List<Line> drawLine(int maxNum, LineCreationStrategy lineCreationStrategy) {
        List<Line> lines = initLine();
        for (int i = 1; i < maxNum; i++) {
            drawLine(lines, lineCreationStrategy);
        }

        return lines;
    }

    private static void drawLine(List<Line> lines, LineCreationStrategy lineCreationStrategy) {
        boolean isCreate = true;
        if (lineCreationStrategy.createLine()) {
            isCreate = lines.get(lines.size() - EXIST_DIVISION).isExist();
            boolean isOrNone = isCreate;

            previousCheck(lines, () -> isOrNone);

            isCreate = false;
        }
        isNotCreateLine(lines, isCreate);
    }

    private static void previousCheck(List<Line> lines, LineCreationStrategy lineCreationStrategy) {

        if (lineCreationStrategy.createLine()) {
            lines.add(Line.NONE_LINE);
            lines.add(Line.STICK);
            return;
        }
        lines.add(Line.IS_LINE);
        lines.add(Line.STICK);
    }

    private static void isNotCreateLine(List<Line> lines, boolean isCreate) {
        if(isCreate) {
            lines.add(Line.NONE_LINE);
            lines.add(Line.STICK);
        }
    }

    private static List<Line> initLine() {
        List<Line> lines = new ArrayList<>();
        lines.add(Line.INIT_LINE);
        lines.add(Line.STICK);
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines = (Lines) o;
        return Objects.equals(this.lines, lines.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public boolean findLines(int index) {
        return lines.get(index).isExist();
    }

}
