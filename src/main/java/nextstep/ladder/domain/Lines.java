package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lines {

    private List<Line> lines;

    public Lines(int maxNum, LineStrategy lineStrategy) {
        this.lines = new ArrayList<>();
        this.lines = drawLine(maxNum, lineStrategy);
    }

    private List<Line> drawLine(int maxNum, LineStrategy lineStrategy) {
        lines.add(Line.INITLINE);

        for (int i = 1; i < maxNum; i++) {
            boolean isCreate = true;
            if (lineStrategy.createLine()) {
                previousCheck(new IsOrNoneAddLines());
                isCreate = false;
            }
            isNotCreateLine(isCreate);
        }

        return lines;
    }

    private void isNotCreateLine(boolean isCreate) {
        if(isCreate) {
            lines.add(Line.NONELINE);
        }
    }

    private void previousCheck(AddLines addLines) {

        if (addLines.draw(lines)) {
            lines.add(Line.NONELINE);
            return;
        }
        lines.add(Line.ISLINE);
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

    public List<String> getLines() {
        List<String> list = new ArrayList<>();
        for(Line line : lines) {
            list.add(line.getLine());
        }
        return list;
    }
}
