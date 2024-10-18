package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private final List<Boolean> lines;

    public LadderLine(List<Boolean> lines) {
        this.lines = lines;
    }

    public static LadderLine of(int groupCount) {
        Deque<Boolean> stack = new ArrayDeque<>();
        return new LadderLine(Stream.of(new Ladder[groupCount - 1])
                .map(empty -> {
                    boolean isLine = needRandom(stack) && booleanFromRandom();
                    stack.push(isLine);
                    return isLine;
                })
                .collect(Collectors.toList()));
    }

    private static boolean needRandom(Deque<Boolean> stack) {
        return stack.isEmpty() || !stack.pop();
    }

    private static boolean booleanFromRandom() {
        return new Random().nextInt(2) == 1;
    }

    public Collection<Boolean> ladderLine() {
        return List.copyOf(lines);
    }
}
