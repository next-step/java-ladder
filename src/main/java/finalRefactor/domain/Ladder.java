package finalRefactor.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderLine> lines;

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public Ladder(Height height, int countOfPerson) {
        lines = createLadder(height, countOfPerson);
    }

    private List<LadderLine> createLadder(Height height, int countOfPerson) {
        return Stream.generate(() -> createLine(countOfPerson, new RandomGenerator()))
                .limit(height.getValue())
                .collect(Collectors.toList());
    }

    private LadderLine createLine(int countOfPerson, PositionGenerator positionGenerator) {
        LadderLine ladderLine = new LadderLine();
        Point first = ladderLine.first(new RandomGenerator());
        ladderLine.body(countOfPerson, first);
        ladderLine.tail(ladderLine.get(ladderLine.size() - 1));
        return ladderLine;
    }

    public int eachPositionResult(int position) {

        for (LadderLine line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public int lineSize() {
        return lines.get(0).size();
    }

    public List<LadderLine> lines() {
        return Collections.unmodifiableList(lines);
    }

    public int size() {
        return lines.size();
    }

}
