package ladder.domain;

import ladder.utils.LadderUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines = new ArrayList<>();

    public Lines(int countOfPerson) {
        createLines(countOfPerson);
    }

    private void createLines(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1)
                .forEach(i -> addPoint());
    }

    private void addPoint() {
        if (this.lines.isEmpty()) {
            this.lines.add(Line.of(LadderUtil.isLine()));
            return;
        }
        checkPointRepeat();
    }

    private void checkPointRepeat() {
        boolean isCurrentOfLine = this.lines.get(lines.size() - 1).getLine();
        boolean isLine = LadderUtil.isLine();
        if (isCurrentOfLine == isLine) {
            this.lines.add(Line.of(!isCurrentOfLine));
            return;
        }

        this.lines.add(Line.of(isLine));
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
