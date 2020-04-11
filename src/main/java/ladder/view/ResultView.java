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

    public static void print(LadderGame result, LadderRewards ladderRewards) {
        System.out.println(LADDER_MESSAGE);
        printUser(result.getUsers());
        printLadderLines(result.getLadder());
        printLadderRewards(ladderRewards);
    }

    private static void printLadderRewards(LadderRewards ladderRewards) {
        List<String> ladderRewardList = ladderRewards.getLadderRewards();
        System.out.println(ladderRewardList.stream()
                .map(reward -> String.format(NAME_FORMAT, reward))
                .collect(Collectors.joining(NAME_DELIMiTER)));
    }

    private static void printUser(List<User> users) {
        System.out.println(users.stream()
                .map(user -> String.format(NAME_FORMAT, user.getName()))
                .collect(Collectors.joining(NAME_DELIMiTER)));
    }

    private static void printLadderLines(List<LadderLine> ladderLines) {
        ladderLines.forEach(ResultView::printLadderLine);
    }

    private static void printLadderLine(LadderLine ladderLine) {
        System.out.println(ladderLine.getLadderLinks()
                .stream()
                .map(link -> link == LadderLink.CONNECT ? LINK_CONNECT : LINK_DIS_CONNECT)
                .collect(Collectors.joining(NODE, EMPTY, NODE)));
    }

    public static void printResult(List<NodeResult> nodeResults) {
        System.out.println(RESULT_MESSAGE);
        nodeResults.forEach(nodeResult -> System.out.println(nodeResult.toString()));
    }
}
