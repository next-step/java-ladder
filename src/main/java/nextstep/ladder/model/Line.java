package nextstep.ladder.model;

import nextstep.ladder.util.InputUtil;
import nextstep.ladder.view.InputTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Line {

    private static final String CONTINUITY_CREATE_MESSAGE = "연속으로 바를 생성할 수 없습니다.";
    private static final String LAST_CREATE_MESSAGE = "마지막 바는 생성할 수 없습니다.";
    private static final String PARTICIPANT_COUNT_EXCEPTION_MESSAGE = "참가자의 수는 최소 2명이여야 합니다.";
    private static final int ONE = 1;
    private static final int TWO = 2;

    private final List<Bar> bars;

    public Line(int participantCount) {
        this(create(participantCount));
    }

    public Line(List<Boolean> bars) {
        validate(bars);
        this.bars = convert(bars);
    }

    private static List<Boolean> create(int participantCount) {
        List<Boolean> bars = new ArrayList<>();
        bars.add(InputUtil.randomBar(null));
        for (int i = ONE; i < participantCount - ONE; i++) {
            bars.add(InputUtil.randomBar(bars.get(i - ONE)));
        }
        bars.add(false);
        return bars;
    }

    private static List<Bar> convert(List<Boolean> bars) {
        return bars.stream()
                .map(Bar::new)
                .collect(Collectors.toList());
    }

    public int barsCount() {
        return bars.size();
    }

    public void validate(List<Boolean> bars) {
        int size = bars.size();
        barCountValidate(size);
        for (int i = ONE; i < size; i++) {
            continuityCreateValidate(bars.get(i - ONE), bars.get(i));
        }
        lastBarCreateValidate(bars.get(size - ONE));
    }

    private void barCountValidate(int size) {
        if (size < TWO) {
            throw new IllegalArgumentException(PARTICIPANT_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void lastBarCreateValidate(boolean currentBarStatus) {
        if (currentBarStatus) {
            throw new IllegalArgumentException(LAST_CREATE_MESSAGE);
        }
    }

    private void continuityCreateValidate(boolean beforeBarStatus, boolean currentBarStatus) {
        if (beforeBarStatus && currentBarStatus) {
            throw new IllegalArgumentException(CONTINUITY_CREATE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(bars, line.bars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bars);
    }

    @Override
    public String toString() {
        return "Line{" +
                "bars=" + bars +
                '}';
    }
}
