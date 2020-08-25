package com.hskim.ladder.model;

import java.util.Iterator;
import java.util.List;

public interface LineIterator extends Iterator {

    int getSize();

    boolean isTargetCounter(List<Integer> targets);

    boolean isOnStartIndex();

    boolean isOnLastIndex();
}
