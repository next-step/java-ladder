package ladder.domain.ladder;

import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.message.ErrorMessages;
import ladder.domain.ladder.unit.Cell;
import ladder.domain.ladder.unit.Ladder;
import ladder.domain.ladder.unit.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderModel {
    private final static int START_COUNT = 1;
    private final static int BEFORE_INDEX = 1;
    private final static int ONE_INDEX = 1;
    
    private Ladder ladder;
    private int cellSize = 0;
    
    public static LadderModel newInstance() {
        return new LadderModel();
    }
    
    public void makeLadder(int cellSize, Gamers gamers) {
        this.cellSize = cellSize;
        this.ladder = Ladder.of(cellSize, gamers.getSize());
    }
    
    public int getGoalNumber(int lineNumber) {
        if (lineNumber >= getSize()) {
            throw new IllegalArgumentException(ErrorMessages.OVER_INPUT_LADDER_SIZE.message());
        }
        return ladder.get(lineNumber).getEndPoint();
    }
    
    public boolean isLadderSizeNeeded() {
        return ladder == null;
    }
    
    public boolean isLadderMade() {
        return !isLadderSizeNeeded();
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
