package nextstep.ladder.domain;

import java.util.*;

public class LadderLine {
    public static final String INVALID_LINE_VALUE_MESSAGE = "사다리 라인은 연속된 두 개의 라인을 가질 수 없습니다.";
    public static final String INVALID_LINE_SIZE_MESSAGE = "사다리 라인의 크기는 1 이상이어야 합니다.";
    private final List<Boolean> values;

    public LadderLine(Boolean[] lines) {
        this(List.of(lines));
    }

    public LadderLine(List<Boolean> lines) {
        valid(lines);
        this.values = Collections.unmodifiableList(lines);
    }

    private void valid(List<Boolean> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(INVALID_LINE_SIZE_MESSAGE);
        }

        for (int i = 0; i < lines.size() - 1; i++) {
            if (lines.get(i) && lines.get(i + 1)) {
                throw new IllegalArgumentException(INVALID_LINE_VALUE_MESSAGE);
            }
        }
    }

    public List<Boolean> getBridgeStatus() {
        return values;
    }

    public static LadderLine generate(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_LINE_SIZE_MESSAGE);
        }

        return new LadderLine(getRandomBooleans(size));
    }

    private static List<Boolean> getRandomBooleans(int size) {
        Random random = new Random();
        List<Boolean> result = new ArrayList<>();

        boolean previous = false;
        for (int i = 0; i < size; i++) {
            boolean current = random.nextBoolean();
            if (previous && current) {
                current = false;
            }
            result.add(current);
            previous = current;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(values);
    }
}
