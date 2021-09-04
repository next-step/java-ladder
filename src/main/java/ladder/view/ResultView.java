package ladder.view;

import java.util.List;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.user.User;

public class ResultView {


    public static final String DEFAULT_USER_PRINT_FORMAT = "%6s";
    public static final String DEFAULT_LINE_PRINT_FORMAT = "     ";
    public static final String CONNECTED_LINE_PRINT_FORMAT = "|-----";
    public static final String DISCONNECTED_LINE_PRINT_FORMAT = "|     ";

    private ResultView() {
    }

    public static void printResult(List<User> users, List<Line> ladders) {
        printUsers(users);
        printLadder(ladders);
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
        sb.append(DEFAULT_LINE_PRINT_FORMAT);
        line.value()
            .forEach(point -> sb.append(getConnected(point)));
        System.out.println(sb);
    }

    private static String getConnected(Point point) {
        if (point.isConnected()) {
            return CONNECTED_LINE_PRINT_FORMAT;
        }
        return DISCONNECTED_LINE_PRINT_FORMAT;
    }

}
