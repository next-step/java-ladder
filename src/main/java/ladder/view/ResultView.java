package ladder.view;

import java.util.List;
import ladder.domain.ladder.LadderResult;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.user.User;

public class ResultView {

    private static final String RESULT_TITLE_PRINT_MESSAGE = "실행결과\n";

    private static final String DEFAULT_USER_PRINT_FORMAT = "%-6s";
    private static final String CONNECTED_LINE_PRINT_FORMAT = "|-----";
    private static final String DISCONNECTED_LINE_PRINT_FORMAT = "|     ";

    private ResultView() {
    }

    public static void printResult(List<User> users, List<Line> ladders, List<String> endPoints) {
        pirntResultTitle();
        printUsers(users);
        printLadder(ladders);
        printResultPoint(endPoints);
    }

    private static void pirntResultTitle() {
        System.out.println(RESULT_TITLE_PRINT_MESSAGE);
    }

    private static void printUsers(List<User> users) {
        StringBuilder sb = new StringBuilder();
        users.stream()
            .map(User::nameToString)
            .map(ResultView::stringFormatByDefaultUserPrintFromat)
            .forEach(sb::append);
        System.out.println(sb);
    }

    private static String stringFormatByDefaultUserPrintFromat(String name) {
        return String.format(DEFAULT_USER_PRINT_FORMAT, name);
    }

    private static void printLadder(List<Line> ladder) {
        ladder.forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        line.value()
            .forEach(point -> sb.append(getConnected(point)));
        System.out.println(sb);
    }

    private static String getConnected(Point point) {
        if (point.isNextConnect()) {
            return CONNECTED_LINE_PRINT_FORMAT;
        }
        return DISCONNECTED_LINE_PRINT_FORMAT;
    }

    public static void printResultPoint(List<String> endPoints) {
        StringBuilder sb = new StringBuilder();
        endPoints.stream()
            .map(ResultView::stringFormatByDefaultUserPrintFromat)
            .forEach(sb::append);
        System.out.println(sb);
    }

    public static void printLadderResult(String username, LadderResult ladderResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(ladderResult.getResultByUser(new User(username)));
        System.out.println(sb);
    }

}
