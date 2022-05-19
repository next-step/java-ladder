package ladder.domain;

import ladder.strategy.GenerationStrategy;
import ladder.strategy.RandomGeneration;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int ladderHeight, People people) {
        this(ladderHeight, people, new RandomGeneration());
    }

    public Ladder(int ladderHeight, People people, GenerationStrategy strategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(people, strategy));
        }
        this.lines = lines;
    }

    public int totalLines() {
        return lines.size();
    }
}
