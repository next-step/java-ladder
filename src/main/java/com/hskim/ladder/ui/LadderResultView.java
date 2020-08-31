package com.hskim.ladder.ui;

import com.google.common.collect.ImmutableMap;
import com.hskim.ladder.model.LadderPoint;

import java.util.List;
import java.util.Map;

public class LadderResultView {
    private static final String RESULT_PHRASE = "실행결과";
    private static final String USER_ALIGN_FORMAT = "%5s ";
    private static final String REWARD_ALIGN_FORMAT = "%-5s ";
    private static final String NEW_LINE = System.lineSeparator();
    private static final Map<LadderPoint, String> pointStringMap = ImmutableMap.of(
            LadderPoint.BLANK, " ",
            LadderPoint.COLUMN, "|",
            LadderPoint.ROW, "-"
    );

    public void printLine(List<LadderPoint> ladderPoints) {
        ladderPoints.stream()
                .map(ladderPoint -> ladderPoint.getPrintString(pointStringMap.get(ladderPoint)))
                .forEach(System.out::print);
    }

    public void printResultPhrase() {
        System.out.println(NEW_LINE + RESULT_PHRASE);
    }

    public void printUserNames(List<String> userNames) {
        System.out.print(NEW_LINE);
        userNames.forEach(userName -> {
            System.out.print(String.format(USER_ALIGN_FORMAT, userName));
        });
        System.out.print(NEW_LINE);
    }

    public void printLines(List<List<LadderPoint>> ladder) {
        ladder.forEach(ladderPoints -> {
            printLine(ladderPoints);
            System.out.print(NEW_LINE);
        });
    }

    public void printRewards(List<String> rewardNames) {
        rewardNames.forEach(rewardName -> {
            System.out.print(String.format(REWARD_ALIGN_FORMAT, rewardName));
        });
        System.out.print(NEW_LINE);
    }
}
