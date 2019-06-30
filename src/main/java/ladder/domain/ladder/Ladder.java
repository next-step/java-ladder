package ladder.domain.ladder;

import ladder.domain.ladder.unit.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final static int START_COUNT = 1;
    private final static int BEFORE_INDEX = 1;
    
    private final int cellSize;
    private final List<Line> ladder;
    
    private Ladder(final int cellSize, final int gamerSize) {
        this.cellSize = cellSize;
        ladder = new ArrayList<>();
        ladder.add(Line.from(cellSize));
        IntStream.range(START_COUNT, gamerSize)
          .forEach(i -> ladder.add(Line.from(ladder.get(i - BEFORE_INDEX), i == gamerSize - BEFORE_INDEX)));
    }
    
    
    public static Ladder from(final int cellSize, final int gamerSize) {
        return new Ladder(cellSize, gamerSize);
    }
    
    public int getSize() {
        return ladder.size();
    }
    
    public Stream<Line> getStream() {
        return ladder.stream();
    }
    
    public int getCellSize() {
        return cellSize;
    }
}
