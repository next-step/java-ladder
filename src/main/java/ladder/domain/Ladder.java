package ladder.domain;

import ladder.strategy.GenerationStrategy;
import ladder.strategy.RandomGeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(Height height, Elements elements) {
        this(height, elements, new RandomGeneration());
    }

    public Ladder(Height height, Elements elements, GenerationStrategy strategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(new Line(elements, strategy));
        }
        this.lines = lines;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void start(Elements elements) {
        elements.toList().forEach(element -> start(element));
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
