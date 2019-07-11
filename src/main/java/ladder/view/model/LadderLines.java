package ladder.view.model;

import ladder.domain.ladder.LadderModel;
import ladder.domain.ladder.unit.Cell;
import ladder.domain.ladder.unit.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLines {
    private final static String EMPTY_STRING = "";
    private final static String LADDER_HORIZON_LINE = "----";
    private final static String LADDER_HORIZON_EMPTY = "    ";
    private final static String LADDER_VERTICAL = "|";
    private final static int START_COUNT = 0;
    
    private final List<String> ladderLines;
    private final LadderModel ladderModel;
    
    private LadderLines(LadderModel ladderModel) {
        this.ladderModel = ladderModel;
        ladderLines = initLines();
        connectLines();
    }
    
    public static LadderLines newLadderLines(LadderModel ladderModel) {
        return new LadderLines(ladderModel);
    }
    
    private List<String> initLines() {
        return IntStream.range(START_COUNT, ladderModel.getCellSize())
          .mapToObj(i -> EMPTY_STRING)
          .collect(Collectors.toList());
    }
    
    private void connectLines() {
        ladderModel.getStream().forEach(this::setLine);
    }
    
    private void setLine(Line line) {
        for (int i = 0; i < line.getSize(); i++) {
            ladderLines.set(i, ladderLines.get(i) + getLine(line.getCell(i)));
        }
    }
    
    private static String getLine(Cell cell) {
        if (cell.isRightConnected()) {
            return LADDER_VERTICAL + LADDER_HORIZON_LINE;
        }
        return LADDER_VERTICAL + LADDER_HORIZON_EMPTY;
    }
    
    public Stream<String> stream() {
        return ladderLines.stream();
    }
}
