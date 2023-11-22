package me.namuhuchutong.ladder.domain;

import java.util.List;

public class LadderGameResultSequence {

    private final List<Integer> sequence;

    public LadderGameResultSequence(List<Integer> sequence) {
        this.sequence = sequence;
    }

    public int convert(int index) {
        validateIndex(index);
        return (sequence.get(index) - 1) / 2;
    }

    private void validateIndex(int index) {
        if (index < 0 || isBiggerThanSize(index)) {
            throw new IllegalArgumentException("주어진 인덱스가 시퀀스 수의 범위를 벗어났습니다. - " + index);
        }
    }

    private boolean isBiggerThanSize(int index) {
        return this.sequence.size() - 1 < index;
    }
}
