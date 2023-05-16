package nextstep.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Line implements Iterable<Boolean> {
    private final LineStrategy strategy;
    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, LineStrategy strategy) {

        this.strategy = strategy;
        points.add(strategy.addLine());

        for (int i = 1; i < countOfPerson - 1; i++) {
            points.add(addLine(i));
        }
    }

    private boolean addLine(int index) {
        if (points.get(index - 1)) {
            return false;
        }

        return strategy.addLine();
    }

    public Stream<String> booleanToLineStream() {
        return this.points.stream()
                .map(this::changeBooleanIntoString);
    }

    private String changeBooleanIntoString(Boolean b) {
        if (b)
            return "-----";

        return "     ";
    }

    @Override
    public Iterator<Boolean> iterator() {
        return points.iterator();
    }

    public int trace(int position) {

        if (isValidPosition(position - 1) && points.get(position - 1)) {
            return position - 1;
        }
        if (isValidPosition(position) && points.get(position)) {
            return position + 1;
        }

        return position;
    }

    private boolean isValidPosition(int position) {
        return position >= 0 && position < points.size();
    }
}
