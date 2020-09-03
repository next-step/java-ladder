package com.hskim.ladder.ui;

import com.google.common.collect.ImmutableMap;
import com.hskim.ladder.model.LadderPoint;
import com.hskim.ladder.model.Point;

import java.util.List;
import java.util.Map;

public class LadderResultView {
    private static final String LADDER_RESULT_PHRASE = "사다리 결과";
    private static final String REWARD_RESULT_PHRASE = "실행 결과";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String COLON = ":";
    private static final String WHITE_SPACE = " ";
    private static final Map<Point, String> pointStringMap = ImmutableMap.of(
            Point.BLANK, " ",
            Point.COLUMN, "|",
            Point.ROW, "-"
    );

    public void printLine(List<LadderPoint> ladderPoints) {
        ladderPoints.stream()
                .map(LadderPoint::getCurrentPoint)
                .map(ladderPoint -> ladderPoint.getPrintString(pointStringMap.get(ladderPoint)))
                .forEach(System.out::print);
    }

    public void printLadderResultPhrase() {
        System.out.println(NEW_LINE + LADDER_RESULT_PHRASE);
    }

    public void printUserNames(String userNameStatus) {
        System.out.print(NEW_LINE);
        System.out.println(userNameStatus);
    }

    public void printLines(List<List<LadderPoint>> ladder) {
        ladder.forEach(ladderPoints -> {
            printLine(ladderPoints);
            System.out.print(NEW_LINE);
        });
    }

    public void printRewards(String rewardStatus) {
        System.out.println(rewardStatus);
        System.out.print(NEW_LINE);
    }

    public void printSimulateResult(Map<String, String> resultMap) {
        if(resultMap.isEmpty()) {
            return;
        }

        System.out.println(NEW_LINE + REWARD_RESULT_PHRASE);
        resultMap.keySet()
                .forEach(key -> System.out.println(key + WHITE_SPACE + COLON + WHITE_SPACE + resultMap.get(key)));
    }
}
