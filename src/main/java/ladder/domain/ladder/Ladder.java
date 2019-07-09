package ladder.domain.ladder;

import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.message.ErrorMessages;
import ladder.domain.ladder.unit.Cell;
import ladder.domain.ladder.unit.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final static int START_COUNT = 1;
    private final static int BEFORE_INDEX = 1;
    private final static int ONE_INDEX = 1;
    
    private final List<Line> ladder;
    private int cellSize;
    
    private Ladder() {
        ladder = new ArrayList<>();
        cellSize = 0;
    }
    
    public static Ladder newInstance() {
        return new Ladder();
    }
    
    public void makeLadder(int cellSize, Gamers gamers) {
        int size = gamers.getSize();
        this.cellSize = cellSize;
        ladder.add(Line.from(cellSize, ladder.size()));
        IntStream.range(START_COUNT, size)
          .forEach(i -> ladder.add(Line.from(ladder.get(i - BEFORE_INDEX), i == size - BEFORE_INDEX, i)));
        setEndPoint();
    }
    
    private void setEndPoint() {
        final int START_POINT = 0;
        for (int ladderIndex = START_POINT, iSize = ladder.size(); ladderIndex < iSize; ladderIndex++) {
            setEndPoint(ladderIndex, START_POINT);
        }
    }
    
    private void setEndPoint(int ladderIndex, int cellIndex) {
        Line nowLine = ladder.get(ladderIndex);
        Cell nowCell = nowLine.get(cellIndex);
        boolean finalCell = false;
        while (!finalCell) {
            finalCell = !(cellIndex + ONE_INDEX < cellSize);
            if (!finalCell) {
                cellIndex = cellIndex + ONE_INDEX;
            }
            if (nowCell.isRightConnected()) {
                ladderIndex = ladderIndex + ONE_INDEX;
            }
            if (nowCell.isLeftConnected()) {
                ladderIndex = ladderIndex - ONE_INDEX;
            }
            nowCell = ladder.get(ladderIndex).get(cellIndex);
        }
        nowLine.setEndPoint(ladderIndex);
    }
    
    public int getRewardNumber(int lineNumber) {
        if (lineNumber >= getSize()) {
            throw new IllegalArgumentException(ErrorMessages.OVER_INPUT_LADDER_SIZE.message());
        }
        return ladder.get(lineNumber).getEndPoint();
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
    
    public List<Line> getLadder() {
        return ladder;
    }
}
