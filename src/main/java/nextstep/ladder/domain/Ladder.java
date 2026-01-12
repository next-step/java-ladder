package nextstep.ladder.domain;

import nextstep.ladder.factory.LineFactory;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int countOfPerson, LineFactory factory) {
        this(IntStream.range(0, height)
                .mapToObj(i -> factory.create(countOfPerson))
                .toList());
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public int move(int startIndex){
        int index = startIndex;
        for(Line line: lines) {
            if(index < line.getPoints().size() && line.hasLine(index)){
                index++;
            } else if (index > 0 && line.hasLine(index - 1)) {
                index--;
            }
        }
        return index;
    }
}
