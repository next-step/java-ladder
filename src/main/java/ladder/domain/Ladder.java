package ladder.domain;

import ladder.domain.line.Line;
import ladder.domain.line.LineStrategy;
import ladder.domain.line.RandomLine;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private int countOfPerson;
    private List<Line> lines;

    private Ladder(int countOfPerson, List<Line> lines) {
        this.countOfPerson = countOfPerson;
        this.lines = lines;
    }

    public static Ladder of(LadderHeight ladderHeight, int countOfPerson) {
        LineStrategy lineStrategy = new RandomLine();
        List lines = IntStream.range(0, ladderHeight.getLadderHeigth())
                .mapToObj(get -> Line.of(countOfPerson, lineStrategy))
                .collect(Collectors.toList());
        return new Ladder(countOfPerson, lines);
    }

    public static Ladder of2(List<Line> lines, int countOfPerson) {
        return new Ladder(countOfPerson,lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
