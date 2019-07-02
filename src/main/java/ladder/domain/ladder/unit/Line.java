package ladder.domain.ladder.unit;

import ladder.domain.ladder.message.ErrorMessages;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private final static Random RANDOM = new Random();
    private final static int START_COUNT = 0;
    private final static int MIN_CELL_SIZE = 1;
    private final static int MAX_NUMBER = 10;
    private final static int DEFAULT_FREQUENCY = 5;
    
    private final List<Cell> cells;
    
    public static Line from(int cellSize) {
        return new Line(cellSize);
    }
    
    public static Line from(Line beforeLine, boolean lastLine) {
        return new Line(beforeLine, lastLine);
    }
    
    private static boolean shouldConnect() {
        return RANDOM.nextInt(MAX_NUMBER) > DEFAULT_FREQUENCY;
    }
    
    private Line(int cellSize) {
        if (cellSize < MIN_CELL_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.CANT_INPUT_LESS_THAN_ZERO.message());
        }
        cells = IntStream.range(START_COUNT, cellSize)
          .mapToObj(i -> Cell.from(shouldConnect()))
          .collect(Collectors.toList());
    }
    
    private Line(Line beforeLine, boolean lastRow) {
        cells = beforeLine.getStream()
          .map(beforeCell -> Cell.from(beforeCell, getConnected(lastRow)))
          .collect(Collectors.toList());
    }
    
    private boolean getConnected(boolean lastRow) {
        return !lastRow && shouldConnect();
    }
    
    public int getSize() {
        return cells.size();
    }
    
    public Cell get(int index) {
        return cells.get(index);
    }
    
    public Stream<Cell> getStream() {
        return cells.stream();
    }
}
