package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderLine;
import ladder.domain.LadderLink;
import ladder.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과\n";
    private static final String NAME_FORMAT = "%5s";
    private static final String NAME_DELIMiTER = " ";
    private static final String NODE = "|";
    private static final String EMPTY = "";
    private static final String LINK_CONNECT = "-----";
    private static final String LINK_DIS_CONNECT = "     ";

    public static void print(LadderGame result) {
        System.out.println(RESULT_MESSAGE);
        printUser(result.getUsers());
        printLadderLines(result.getLadder());
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
}
