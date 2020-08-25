package com.hskim.ladder.ui;

import com.google.common.collect.ImmutableMap;
import com.hskim.ladder.model.LadderPoint;

import java.util.List;
import java.util.Map;

public class LadderResultView {
    private static final Map<LadderPoint, String> pointStringMap = ImmutableMap.of(
            LadderPoint.BLANK, " ",
            LadderPoint.COLUMN, "|",
            LadderPoint.ROW, "-"
    );

    public void printLine(List<LadderPoint> ladderPoints) {
        ladderPoints.stream()
                .map(ladderPoint -> ladderPoint.toString(pointStringMap.get(ladderPoint)))
                .forEach(System.out::print);
    }
}
