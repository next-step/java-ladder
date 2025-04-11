package nextstep.ladder.domain;

import java.util.*;

public class LadderLine {
    public static final String INVALID_LINE_VALUE_MESSAGE = "사다리 라인은 연속된 두 개의 라인을 가질 수 없습니다.";
    public static final String INVALID_LINE_SIZE_MESSAGE = "사다리 라인의 크기는 1 이상이어야 합니다.";
    private final List<Bridge> values;

    public LadderLine(List<Bridge> lines) {
        valid(lines);
        this.values = Collections.unmodifiableList(lines);
    }

    private void valid(List<Bridge> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(INVALID_LINE_SIZE_MESSAGE);
        }

        for (int i = 0; i < lines.size() - 1; i++) {
            validPairValue(lines.get(i), lines.get(i + 1));
        }
    }

    private static void validPairValue(Bridge current, Bridge next) {
        if (current.isConnected() && next.isConnected()) {
            throw new IllegalArgumentException(INVALID_LINE_VALUE_MESSAGE);
        }
    }

    public List<Bridge> getBridgeStatus() {
        return values;
    }

    public int size() {
        return values.size();
    }

    public static LadderLine generate(int size) {
        validSize(size);

        List<Bridge> result = new ArrayList<>();
        Bridge prev = new Bridge();
        result.add(prev);

        for (int i = 1; i < size; i++) {
            Bridge next = prev.nextBridge();
            result.add(next);
            prev = next;
        }

        return new LadderLine(result);
    }

    private static void validSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_LINE_SIZE_MESSAGE);
        }
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
