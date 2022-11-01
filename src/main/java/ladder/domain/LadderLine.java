package ladder.domain;

import ladder.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderLine {
    private final List<Boolean> parts;

    public LadderLine(int countOfMember, LineCreateStrategy lineCreateStrategy) {
        this(createLine(countOfMember, lineCreateStrategy));
    }

    public LadderLine(List<Boolean> parts) {
        this.parts = parts;
    }

    public static List<Boolean> createLine(int countOfMember, LineCreateStrategy lineCreateStrategy) {
        List<Boolean> values = new ArrayList<>(countOfMember);
        IntStream.range(0, countOfMember)
                .forEach(count -> values.add(makePart(values, count, lineCreateStrategy)));
        return values;
    }

    private static Boolean makePart(List<Boolean> values, int count, LineCreateStrategy lineCreateStrategy) {
        if(values.isEmpty() || values.get(count - 1)) {
            return false;
        }
        return lineCreateStrategy.create();
    }

    public List<Boolean> parts() {
        return List.copyOf(parts);
    }
}
