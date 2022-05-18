package ladder.domain;

import ladder.strategy.GenerationStrategy;
import ladder.strategy.RandomGeneration;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int ladderHeight, int countOfPerson) {
        this(ladderHeight, countOfPerson, new RandomGeneration());
    }

    public Ladder(int ladderHeight, int countOfPerson, GenerationStrategy strategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countOfPerson, strategy));
        }
        this.lines = lines;
    }

    public int totalLines() {
        return lines.size();
    }
}
