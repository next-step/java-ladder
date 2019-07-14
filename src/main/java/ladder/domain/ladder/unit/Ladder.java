package ladder.domain.ladder.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final static int START_COUNT = 1;
    private final static int ONE_INDEX = 1;
    
    private final List<Line> ladder = new ArrayList<>();
    
    private Ladder(int cellSize, int rowSize) {
        ladder.add(Line.from(cellSize, ladder.size()));
        IntStream.range(START_COUNT, rowSize)
            .forEach(i -> ladder.add(Line.from(ladder.get(i - ONE_INDEX), i == rowSize - ONE_INDEX, i)));
        setEndPoint(cellSize);
    }
    
    public static Ladder of(int cellSize, int rowSize) {
        return new Ladder(cellSize, rowSize);
    }
    
    private void setEndPoint(int cellSize) {
        final int START_POINT = 0;
        for (int ladderIndex = START_POINT, size = ladder.size(); ladderIndex < size; ladderIndex++) {
            setEndPoint(ladderIndex, cellSize);
        }
    }
    
    private void setEndPoint(int ladderIndex, int cellSize) {
        Line nowLine = ladder.get(ladderIndex);
        int cellIndex = START_COUNT;
        Cell nowCell = nowLine.getCell(cellIndex);
        boolean finalCell = false;
        while (!finalCell) {
            finalCell = !(cellIndex + ONE_INDEX < cellSize);
            cellIndex = getCellIndex(cellIndex, finalCell);
            ladderIndex = getLadderIndex(nowCell, ladderIndex);
            nowCell = ladder.get(ladderIndex).getCell(cellIndex);
        }
        nowLine.setEndPoint(ladderIndex);
    }
    
    private int getCellIndex(final int cellIndex, final boolean finalCell) {
        return !finalCell ? cellIndex + ONE_INDEX : cellIndex;
    }
    
    private int getLadderIndex(final Cell nowCell, final int ladderIndex) {
        return nowCell.isRightConnected() ? ladderIndex + ONE_INDEX :
            nowCell.isLeftConnected() ? ladderIndex - ONE_INDEX : ladderIndex;
    }
    
    public Line get(int index) {
        return ladder.get(index);
    }
    
    public int size() {
        return ladder.size();
    }
    
    public Stream<Line> stream() {
        return ladder.stream();
    }
    
    
    public int cellSize() {
        return ladder.get(0).cellSize();
    }
}
