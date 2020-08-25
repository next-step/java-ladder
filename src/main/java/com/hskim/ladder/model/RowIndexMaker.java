package com.hskim.ladder.model;

import java.util.List;

@FunctionalInterface
public interface RowIndexMaker {

    List<Integer> getNumbers(int bound);
}
