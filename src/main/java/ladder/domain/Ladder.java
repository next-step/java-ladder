package ladder.domain;

import ladder.strategy.GenerationStrategy;
import ladder.strategy.RandomGeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(Height height, People people) {
        this(height, people, new RandomGeneration());
    }

    public Ladder(Height height, People people, GenerationStrategy strategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(people, strategy));
        }
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void start(People people) {
        people.toList().forEach(person -> start(person));
    }

    private void start(Element element) {
        lines.stream()
                .map(line -> line.direction(element.position()))
                .forEach(element::move);
    }

    public int totalLines() {
        return lines.size();
    }
}
