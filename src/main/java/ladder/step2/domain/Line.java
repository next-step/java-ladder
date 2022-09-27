package ladder.step2.domain;

import ladder.step2.domain.strategy.LineCreateStrategy;
import ladder.step2.domain.strategy.RandomLineCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> partLines;
    
    public Line(int countOfPlayers) {
        this(countOfPlayers, new RandomLineCreateStrategy());
                
    }
    
    public Line(int countOfPlayers, LineCreateStrategy lineCreateStrategy) {
        this.partLines = new ArrayList<>();
        initPartLines(countOfPlayers, lineCreateStrategy);
    }
    
    private void initPartLines(int countOfPlayers, LineCreateStrategy lineCreateStrategy) {
        IntStream.range(0, countOfPlayers)
                .forEach(count -> lineCreateStrategy.addPartLine(partLines, countOfPlayers));
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(partLines, line.partLines);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(partLines);
    }
}
