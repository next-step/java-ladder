package nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private final LineStrategy strategy;
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, LineStrategy strategy) {
        this.strategy = strategy;

        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(addLine(i));
        }
    }

    private boolean addLine(int index) {
        if (index == 0 || !points.get(index - 1)) {
            return strategy.addLine();
        }

        return false;
    }

    public Stream<Boolean> lineStream() {
        return this.points.stream();
    }

    public int trace(int position) {
        return IntStream.rangeClosed(position - 1, position)
                .filter(x -> isValidPosition(x) && points.get(x))
                .map(x -> hasLinePosition(position, x))
                .findAny()
                .orElse(position);
    }

    private boolean isValidPosition(int position) {
        return position >= 0 && position < points.size();
    }

    private int hasLinePosition(int position, int x) {
        if (x == position - 1) {
            return position - 1;
        }

        return position + 1;
    }
}
