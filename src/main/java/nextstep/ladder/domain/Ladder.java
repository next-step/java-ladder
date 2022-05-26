package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private static final String EMPTY_LINE_EXCEPTION = "하나 이상의 라인이 필요합니다.";
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);
        this.lines = lines;
    }

    void validate(List<Line> lines){
        if(lines == null || lines.size() < MIN_LADDER_HEIGHT){
            throw new IllegalArgumentException(EMPTY_LINE_EXCEPTION);
        }
    }

    public int findResult(int startIndex) {
        int index = startIndex;
        for(Line line: lines){
            index = line.moveFrom(index);
        }
        return index;
    }

    public static Ladder of(int rowCnt, int colCnt, PointCreationRule pointCreationRule) {
        List<Line> lines = new ArrayList<>();
        for(int i=0; i<rowCnt; i++){
            lines.add(Line.of(colCnt, pointCreationRule));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString(){
        return "{"
                + lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"))
                +"}";
    }

}
