package ladder.domain.ladder;

import ladder.domain.ladder.message.ErrorMessages;
import ladder.domain.ladder.util.ConnectChooser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Row {
    private final static int START_COUNT = 0;
    private final static int MIN_CELLS_SIZE = 1;
    
    private final List<Cell> cells;
    
    private Row(int cellsSize) {
        if (cellsSize < MIN_CELLS_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.CANT_INPUT_LESS_THAN_ZERO.message());
        }
        
        cells = IntStream.range(START_COUNT, cellsSize)
          .mapToObj(i -> Cell.from(ConnectChooser.shouldConnect()))
          .collect(Collectors.toList());
    }
    
    private Row(Row beforeRow, boolean lastRow) {
        cells = beforeRow.stream()
          .map(beforeCell -> Cell.from(beforeCell, getConnected(lastRow)))
          .collect(Collectors.toList());
    }
    
    private boolean getConnected(boolean lastRow) {
        return lastRow ? false : ConnectChooser.shouldConnect();
    }
    
    public static Row from(int cellsSize) {
        return new Row(cellsSize);
    }
    
    public static Row from(Row beforeRow, boolean lastRow) {
        return new Row(beforeRow, lastRow);
    }
    
    public int getSize() {
        return cells.size();
    }
    
    private Stream<Cell> stream() {
        return cells.stream();
    }
    
    public Cell get(int index) {
        return cells.get(index);
    }
    
    public Stream<Cell> getStream() {
        return cells.stream();
    }
}
