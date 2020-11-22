package step4.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.function.Consumer;

public class LadderLine {
    private final List<Line> ladderLine;

    public LadderLine(List<Line> ladderLine) {
        this.ladderLine = Collections.unmodifiableList(ladderLine);
    }

    public void forEach(Consumer<Line> function) {
        ladderLine.forEach(function);
    }

    public Line get(int index) {
        isValidIndex(index);
        return ladderLine.get(index);
    }

    private void isValidIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (ladderLine.size() <= index) {
            throw new NoSuchElementException();
        }
    }

    public Point getArrivalPoint(Point startPosition) {
        Stack<Point> current = new Stack<Point>() {{
            push(startPosition);
        }};
        forEach(line -> current.push(line.nextPosition(current.pop())));

        return current.pop();
    }

    public Point nextPosition(Point start) {
        Line currentLine = get(start.getY());
        return currentLine.nextPosition(start);
    }
}
