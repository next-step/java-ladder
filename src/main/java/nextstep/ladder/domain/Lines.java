package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Lines {

    private List<Line> lines;

    public Lines(List<Line> lines, int maxNum, LineCreationStrategy lineCreationStrategy) {
        this.lines = lines;
        this.lines = drawLine(maxNum, lineCreationStrategy);
    }

    public static Lines of (List<Line> lines, int maxNum, LineCreationStrategy lineCreationStrategy) {
        return new Lines(lines, maxNum, lineCreationStrategy);
    }

    private List<Line> drawLine(int maxNum, LineCreationStrategy lineCreationStrategy) {

        for (int i = 1; i < maxNum; i++) {
            drawLine(lineCreationStrategy);
        }

        return lines;
    }

    private void drawLine(LineCreationStrategy lineCreationStrategy) {
        boolean isCreate = true;
        if (lineCreationStrategy.createLine()) {
            isCreate = lines.get(lines.size() - 1).isExist();
            boolean isOrNone = isCreate;

            previousCheck(() -> isOrNone);

            isCreate = false;
        }
        isNotCreateLine(isCreate);
    }

    private void previousCheck(LineCreationStrategy lineCreationStrategy) {

        if (lineCreationStrategy.createLine()) {
            lines.add(Line.NONELINE);
            return;
        }
        lines.add(Line.ISLINE);
    }

    private void isNotCreateLine(boolean isCreate) {
        if(isCreate) {
            lines.add(Line.NONELINE);
        }
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
}
