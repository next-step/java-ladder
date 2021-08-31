package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Ladder {

    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int moveFrom(int index) {
        int next = index;
        for (int i = 0; i < getHeight(); i++) {
            next = lines.get(i).move(next);
        }
        return next;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getWidth() {
        return lines.get(0).getWidth();
    }

    public int getHeight() {
        return lines.size();
    }

    public List<Integer> moveAll() {
        return IntStream.range(0, getHeight())
                .mapToObj(this::moveFrom)
                .collect(Collectors.toList());
    }
}
