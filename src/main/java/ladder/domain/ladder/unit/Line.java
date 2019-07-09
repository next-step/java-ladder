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
    private final int startPoint;
    private int endPoint;
    
    private Line(Line beforeLine, boolean lastRow, int startPoint) {
        cells = beforeLine.getStream()
            .map(beforeCell -> Cell.from(beforeCell, getConnected(lastRow)))
            .collect(Collectors.toList());
        this.startPoint = startPoint;
    }
    
    private Line(int cellSize, int startPoint) {
        if (cellSize < MIN_CELL_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.CANT_INPUT_LESS_THAN_ZERO.message());
        }
        cells = IntStream.range(START_COUNT, cellSize)
            .mapToObj(i -> Cell.from(shouldConnect()))
            .collect(Collectors.toList());
        this.startPoint = startPoint;
    }
    
    public static Line from(int cellSize, int startPoint) {
        return new Line(cellSize, startPoint);
    }
    
    public static Line from(Line beforeLine, boolean lastLine, int startPoint) {
        return new Line(beforeLine, lastLine, startPoint);
    }
    
    private static boolean shouldConnect() {
        return RANDOM.nextInt(MAX_NUMBER) > DEFAULT_FREQUENCY;
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
    
    public boolean isStartPointAt(int point) {
        return startPoint == point;
    }
    
    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }
    
    public int getEndPoint() {
        return endPoint;
    }
}
