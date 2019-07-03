package ladder.domain.ladder;

import ladder.domain.ladder.unit.Cell;
import ladder.domain.ladder.unit.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final static int START_COUNT = 1;
    private final static int BEFORE_INDEX = 1;
    
    private final List<Line> ladder;
    private final int cellSize;
    
    private Ladder(final int cellSize, final int gamerSize) {
        this.cellSize = cellSize;
        ladder = new ArrayList<>();
        ladder.add(Line.from(cellSize, ladder.size()));
        IntStream.range(START_COUNT, gamerSize)
          .forEach(i -> ladder.add(Line.from(ladder.get(i - BEFORE_INDEX), i == gamerSize - BEFORE_INDEX, i)));
        setEndPoint();
    }
    
    private void setEndPoint() {
        final int START_POINT = 0;
        for (int ladderIndex = START_POINT, iSize = ladder.size(); ladderIndex < iSize; ladderIndex++) {
            int x = ladderIndex;
            int y = START_POINT;
            Line nowLine = ladder.get(x);
            Cell nowCell = nowLine.get(y);
            boolean finalCell = false;
            while (!finalCell) {
                if (y + 1 < cellSize) {
                    y = y + 1;
                } else  {
                    finalCell = true;
                }
                if (nowCell.isRightConnected()) {
                    x = x + 1;
                }
                if (nowCell.isLeftConnected()) {
                    x = x - 1;
                }
                nowCell = ladder.get(x).get(y);
            }
            nowLine.setEndPoint(x);
        }
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
