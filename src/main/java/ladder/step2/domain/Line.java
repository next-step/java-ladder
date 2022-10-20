package ladder.step2.domain;

import ladder.step2.domain.partlinestrategy.PartLineCreateStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> line;
    
    private Line(List<Point> line) {
        this.line = line;
    }
    
    public static Line of(final int countOfPlayers, final PartLineCreateStrategy partLineCreateStrategy) {
        LinkedList<Point> line = new LinkedList<>();
        line.add(Point.createFirst(partLineCreateStrategy));
        IntStream.range(1, countOfPlayers - 1)
                .forEach(count -> line.add(line.getLast().createNext(partLineCreateStrategy)));
        line.add(line.getLast().createLast());
        return new Line(line);
    }
    
    public int move(final int currentPosition) {
        return line.get(currentPosition).move();
    }
    
    public List<Point> getLine() {
        return line;
    }
    
    @Override
    public String toString() {
        return "Line{" +
                "line=" + line +
                '}';
    }
}
