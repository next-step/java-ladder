package nextstep.ladder.domain;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private static final Random RANDOM = new Random();

    private final List<Boolean> lines;

    public LadderLine(List<Boolean> lines) {
        this.lines = lines;
    }

    public static LadderLine of(int groupCount) {
        Deque<Boolean> stack = new ArrayDeque<>();
        return Stream.of(new Ladder[groupCount - 1])
                .map(empty -> {
                    boolean isLine = needRandom(stack) && booleanFromRandom();
                    stack.push(isLine);
                    return isLine;
                })
                .collect(Collectors.collectingAndThen(Collectors.toList(), LadderLine::new));
    }

    private static boolean needRandom(Deque<Boolean> stack) {
        return stack.isEmpty() || !stack.pop();
    }

    private static boolean booleanFromRandom() {
        return RANDOM.nextInt(2) == 1;
    }

    public Collection<Boolean> copy() {
        return List.copyOf(lines);
    }
}
