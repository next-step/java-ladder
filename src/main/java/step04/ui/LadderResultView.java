package step04.ui;

import java.util.Map;

public class LadderResultView {
    private static final String LADDER_RESULT_PHRASE = "사다리 결과";
    private static final String REWARD_RESULT_PHRASE = "실행 결과";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String COLON = ":";
    private static final String WHITE_SPACE = " ";

    public void printLadderResultPhrase() {
        System.out.println(NEW_LINE + LADDER_RESULT_PHRASE);
    }

    public void printUserNames(String userNameStatus) {
        System.out.print(NEW_LINE);
        System.out.println(userNameStatus);
    }

    public void printLadderLines(String ladderLinesStatus) {
        System.out.println(ladderLinesStatus);
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
