package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final static int START_COUNT = 1;
    private final static int BEFORE_INDEX = 1;
    
    private final List<Row> ladder;
    
    private Ladder(final int rowsSize, final int cellsSize) {
        ladder = new ArrayList<>();
        ladder.add(Row.from(cellsSize));
        IntStream.range(START_COUNT, rowsSize)
          .forEach(i -> ladder.add(Row.from(ladder.get(i - BEFORE_INDEX), i == rowsSize)));
    }
    
    
    public static Ladder from(final int rowsSize, final int cellsSize) {
        return new Ladder(rowsSize, cellsSize);
    }
    
    public int getSize() {
        return ladder.size();
    }
}
