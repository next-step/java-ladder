package ladder.domain.ladder.unit;

import ladder.domain.ladder.message.ErrorMessages;

import java.util.stream.Stream;

public class Line {
    private final static int MIN_CELL_SIZE = 1;
    
    private final Cells cells;
    private final Points points;
    
    private Line(Line beforeLine, boolean lastRow, int startPoint) {
        cells = Cells.of(beforeLine, lastRow);
        points = Points.from(startPoint);
    }
    
    private Line(int cellSize, int startPoint) {
        if (cellSize < MIN_CELL_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.CANT_INPUT_LESS_THAN_ZERO.message());
        }
        cells = Cells.from(cellSize);
        points = Points.from(startPoint);
    }
    
    public static Line from(int cellSize, int startPoint) {
        return new Line(cellSize, startPoint);
    }
    
    public static Line from(Line beforeLine, boolean lastLine, int startPoint) {
        return new Line(beforeLine, lastLine, startPoint);
    }
    
    public boolean isStartPointAt(int point) {
        return points.isStartPoint(point);
    }
    
    void setEndPoint(int endPoint) {
        points.setEndPoint(endPoint);
    }
    
    public int getEndPoint() {
        return points.getEndPoint();
    }
    
    public Cell getCell(int cellIndex) {
        return cells.getCell(cellIndex);
    }
    
    int cellSize() {
        return cells.size();
    }
    
    
    public Stream<Cell> stream() {
        return cells.stream();
    }
    
    public int getSize() {
        return cells.size();
    }
}
