package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_MESSAGE = "사다리 결과\n";
    private static final String NAME_FORMAT = "%5s";
    private static final String NAME_DELIMiTER = " ";
    private static final String NODE = "|";
    private static final String EMPTY = "";
    private static final String LINK_CONNECT = "-----";
    private static final String LINK_DIS_CONNECT = "     ";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String TARGET_ALL = "all";

    public static void print(Ladder ladder, LadderGameInfo ladderGameInfo) {
        System.out.println(LADDER_MESSAGE);
        printUser(ladderGameInfo.getUsers());
        printLadderLines(ladder.getLadderLines());
        printLadderRewards(ladderGameInfo.getLadderRewards());
    }

    private static void printUser(List<User> users) {
        System.out.println(users.stream()
                .map(user -> String.format(NAME_FORMAT, user.toString()))
                .collect(Collectors.joining(NAME_DELIMiTER)));
    }

    private static void printLadderLines(List<LadderLine> ladderLines) {
        ladderLines.forEach(ResultView::printLadderLine);
    }

    private static void printLadderLine(LadderLine ladderLine) {
        System.out.println(ladderLine.getPoints()
                .stream()
                .map(point -> point.getDirection().isLeft() ? LINK_CONNECT : LINK_DIS_CONNECT)
                .collect(Collectors.joining(NODE, EMPTY, NODE)));
    }

    private static void printLadderRewards(List<LadderReward> ladderRewards) {
        System.out.println(ladderRewards.stream()
                .map(reward -> String.format(NAME_FORMAT, reward.toString()))
                .collect(Collectors.joining(NAME_DELIMiTER)));
    }

    public static void printResult(String inputTarget, LadderGameResults results) {
        System.out.println(RESULT_MESSAGE);
        if (TARGET_ALL.equals(inputTarget)) {
            results.getResults().forEach((user, reward)
                    -> System.out.println(String.format(RESULT_FORMAT, user.toString(), reward.toString())));
            return;
        }
        System.out.println(results.getLadderReward(inputTarget));
    }
}
