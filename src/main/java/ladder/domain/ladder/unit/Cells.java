package ladder.domain.ladder.unit;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Cells {
    private final static Random RANDOM = new Random();
    private final static int START_COUNT = 0;
    
    private final static int MAX_NUMBER = 10;
    private final static int DEFAULT_FREQUENCY = 5;
    
    private final List<Cell> cells;
    
    private Cells(Line beforeLine, boolean lastRow) {
        cells = beforeLine.stream()
          .map(beforeCell -> Cell.from(beforeCell, getConnected(lastRow)))
          .collect(Collectors.toList());
    }
    
    private Cells(int cellSize) {
        cells = IntStream.range(START_COUNT, cellSize)
          .mapToObj(i -> Cell.from(shouldConnect()))
          .collect(Collectors.toList());
    }
    
    static Cells of(Line beforeLine, boolean lastRow) {
        return new Cells(beforeLine, lastRow);
    }
    
    public static Cells from(int cellSize) {
        return new Cells(cellSize);
    }
    
    private static boolean shouldConnect() {
        return RANDOM.nextInt(MAX_NUMBER) > DEFAULT_FREQUENCY;
    }
    
    private boolean getConnected(boolean lastRow) {
        return !lastRow && shouldConnect();
    }
    
    int size() {
        return cells.size();
    }
    
    Cell getCell(int index) {
        return cells.get(index);
    }
    
    public Stream<Cell> stream() {
        return cells.stream();
    }
}
