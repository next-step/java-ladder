package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final int width;
    private final int height;
    private final MoveStrategy moveStrategy;
    private List<Line> lines;

    public Ladder(int width, int height, MoveStrategy moveStrategy) {
        this.width = width;
        this.height = height;
        this.moveStrategy = moveStrategy;
        makeLines();
    }

    private void makeLines() {
        lines = IntStream.range(0, height)
                .mapToObj((num)-> moveStrategy.generate(width))
                .map(Line::of)
                .collect(Collectors.toList());
    }

    public int moveFrom(int index) {
        int next = index;
        for (int i = 0; i < height; i++) {
            next = lines.get(i).move(next);
        }
        return next;
    }

    public List<Line> getLines(){
        return lines;
    }

}
