package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLevel {

    private final List<Boolean> lines;

    public LadderLevel(List<Boolean> lines) {
        this.lines = lines;
    }

    public static LadderLevel of(int groupCount) {
        Deque<Boolean> stack = new ArrayDeque<>();

        return new LadderLevel(IntStream.range(0, groupCount - 1)
                .mapToObj(i -> {
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

    public int count() {
        return lines.size();
    }

    public Collection<Boolean> ladderLevel() {
        return List.copyOf(lines);
    }
}
