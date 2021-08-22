package ladder.domain.ladder.ladder;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.line.Line;
import ladder.dto.LadderResult;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        validate(lines);
        this.lines = lines;
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public int permute(int source) {
        int destination = source;
        for (Line line : lines) {
            destination = line.permute(destination);
        }
        return destination;
    }

    public LadderResult permute() {
        Map<Integer, Integer> permutation = IntStream.range(0, sizeOfLine())
                .boxed()
                .collect(Collectors.toMap(Function.identity(), this::permute));
        return LadderResult.of(permutation);
    }

    public int sizeOfLine() {
        return lines.get(0).size();
    }

    public int height() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }

    private void validate(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
