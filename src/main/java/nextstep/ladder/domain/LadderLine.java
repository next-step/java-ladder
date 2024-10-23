package nextstep.ladder.domain;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private static final int RANDOM_BOUND = 2;
    private static final int VALUE_FOR_LINE = 1;
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
        return RANDOM.nextInt(RANDOM_BOUND) == VALUE_FOR_LINE;
    }

    public <T> void play(List<T> elements) {
        if (lines.size() != lineCount(elements)) {
            throw new IllegalArgumentException("사다리 라인 수와 참가자 리스트 수가 맞지 않습니다.");
        }

        for (int i = 0; i < lines.size(); i++) {
            swap(elements, i);
        }
    }

    private int lineCount(List<?> elements) {
        return elements.size() - 1;
    }

    private <T> void swap(List<T> elements, int i) {
        if (lines.get(i)) {
            Collections.swap(elements, i, i + 1);
        }
    }

    public Collection<Boolean> copy() {
        return List.copyOf(lines);
    }
}
