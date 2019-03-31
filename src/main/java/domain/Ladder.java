package domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void paint(Consumer<Line> consumer) {
        lines.forEach(consumer);
    }

    StoryResult getResult() {
        StoryResult storyResult = new StoryResult(
            IntStream
                .range(0, lines.get(0).size() + 1)
                .boxed()
                .collect(Collectors.toList()));

        for (Line line : lines) {
            storyResult = storyResult.move(line);
        }

        return storyResult;
    }
}
