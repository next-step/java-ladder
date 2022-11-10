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

    public int drawPart(int part) {
        if (!isFirstPart(part) && getLeftPart(part)) {
            return part - 1;
        }
        if (!isLastPart(part) && getRightPart(part)) {
            return part + 1;
        }
        return part;
    }

    private boolean getLeftPart(int part) {
        return parts.get(part);
    }

    private boolean getRightPart(int part) {
        return parts.get(part + 1);
    }

    private boolean isLastPart(int part) {
        return part == parts.size() - 1;
    }

    private boolean isFirstPart(int part) {
        return part == 0;
    }

    private static List<Boolean> createLine(int countOfMember, LineCreateStrategy lineCreateStrategy) {
        List<Boolean> values = new ArrayList<>(countOfMember);
        IntStream.range(0, countOfMember)
                .forEach(count -> values.add(makePart(values, count, lineCreateStrategy)));
        return values;
    }

    private static Boolean makePart(List<Boolean> values, int count, LineCreateStrategy lineCreateStrategy) {
        if (values.isEmpty() || values.get(count - 1)) {
            return false;
        }
        return lineCreateStrategy.create();
    }

    public List<Boolean> parts() {
        return List.copyOf(parts);
    }
}
