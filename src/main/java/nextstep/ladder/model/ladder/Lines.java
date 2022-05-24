package nextstep.ladder.model.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static nextstep.ladder.model.ConstantNumber.ZERO;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int countOfPeople, int maxHeight) {
        List<Line> lines = IntStream
                .range(ZERO.getValue(), maxHeight)
                .mapToObj(i -> Line.init(countOfPeople))
                .collect(Collectors.toList());

        return Lines.of(lines);
    }

    public static Lines of(List<Line> lines) {
        return new Lines(lines);
    }

    public List<Line> unwrap() {
        return Collections.unmodifiableList(this.lines);
    }

    public int moveDown(int row, int column) {
        if (row == this.size()) {
            return column;
        }
        Line line = this.line(row);
        int nextColumn = line.move(column);
        return moveDown(++row, nextColumn);
    }

    public Line line(int row) {
        return this.lines.get(row);
    }

    public int size() {
        return this.lines.size();
    }
}
