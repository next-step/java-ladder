package ladder.domain;

import ladder.strategy.LineGenerateStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(Line... lines){
        this(Arrays.asList(lines));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public static Lines from(int linesSize, int lineSize, LineGenerateStrategy strategy) {
        List<Line> result = new ArrayList<>();
        for (int i = 0; i < linesSize; i++) {
            result.add(Line.from(lineSize, strategy));
        }
        return new Lines(result);
    }

    public int getResult(int participantOrder){
        Integer index = participantOrder;
        for (Line line : lines) {
            if(line.isLastPoint(index)) {
                if(line.getPoint(index)) index--;
                continue;
            }
            if(line.getPoint(index+1)) {
                index++;
                continue;
            }
            if(line.getPoint(index)) index--;
        }
        return index;
    }
}
