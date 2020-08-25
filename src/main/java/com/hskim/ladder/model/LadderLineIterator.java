package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;

public class LadderLineIterator implements LineIterator {
    private static final int START_INDEX = 0;
    private int size;
    private int counter = START_INDEX;

    public LadderLineIterator(LadderUsers ladderUsers) {
        this.size = ladderUsers.getUserNumber();
    }

    public LadderLineIterator(int size) {
        this.size = size;
    }

    public LadderLineIterator(int size, int counter) {
        this(size);
        this.counter = counter;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isTargetCounter(List<Integer> targets) {
        return targets.contains(counter);
    }

    @Override
    public boolean isOnStartIndex() {
        return counter == START_INDEX;
    }

    @Override
    public boolean isOnLastIndex() {
        return counter == size;
    }

    @Override
    public boolean hasNext() {
        return size >= counter;
    }

    @Override
    public Object next() {
        return counter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLineIterator)) return false;
        LadderLineIterator lineSize = (LadderLineIterator) o;
        return size == lineSize.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

}
