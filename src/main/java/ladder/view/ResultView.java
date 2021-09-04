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
        for (User user : users) {
            System.out.printf(DEFAULT_USER_PRINT_FORMAT, user.nameToString());
        }
        System.out.println();
    }

    private static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            System.out.print(DEFAULT_LINE_PRINT_FORMAT);
            for (Point point : line.value()) {
                if (point.isConnected()) {
                    System.out.print(CONNECTED_LINE_PRINT_FORMAT);
                } else {
                    System.out.print(DISCONNECTED_LINE_PRINT_FORMAT);
                }
            }
            System.out.println();
        }
    }

}
